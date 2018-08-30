package com.stackroute.eplay.ticketengine.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stackroute.eplay.ticketengine.domain.BlockedSeats;
import com.stackroute.eplay.ticketengine.domain.InputEmailDetails;
import com.stackroute.eplay.ticketengine.domain.Show;
import com.stackroute.eplay.ticketengine.repository.ShowRepository;
import com.stackroute.eplay.ticketengine.service.BlockedSeatsService;
import com.stackroute.eplay.ticketengine.streams.BookedSeatsStream;
import com.stackroute.eplay.ticketengine.streams.EmailStream;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
@EnableBinding({BookedSeatsStream.class, EmailStream.class})
public class TicketEngineController {
	
	private ShowRepository showRepository;
	private BlockedSeatsService blockedSeatsService;
	private BookedSeatsStream bookedSeatsStream;
	private EmailStream emailStream;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TicketEngineController(ShowRepository showRepository, BlockedSeatsService blockedSeatsService, BookedSeatsStream bookedSeatsStream, EmailStream emailStream){
		this.showRepository = showRepository;
		this.blockedSeatsService = blockedSeatsService;
		this.bookedSeatsStream = bookedSeatsStream;
		this.emailStream = emailStream;
	}
	
	@MessageMapping("/send/message")
    @SendTo("/chat")
    public BlockedSeats seats(BlockedSeats seats) throws Exception {
		logger.info("Socket Seat: "+seats.toString());
		
		// return new Show("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
		return blockedSeatsService.save(seats);
    }
	
	@PostMapping("/show")
	public ResponseEntity<?> saveShow(@RequestBody Show show) {
		/*show.setSeats(new HashMap<Integer, String>());
		for(int i=0;i<100;i++) {
			if(i==30 || i==33 || i==34)
				show.getSeats().put(i, "booked");
			else if(i==35|| i==36||i==37)
				show.getSeats().put(i, "blocked");
			else
				show.getSeats().put(i, "open");
		}*/
		showRepository.save(show);
		return new ResponseEntity<Show>(show,  HttpStatus.OK);
	}
	
	
	@PutMapping("/show")
	public ResponseEntity<?> updateShow(@RequestBody Show show) {
		showRepository.update(show);
		return new ResponseEntity<Show>(show,  HttpStatus.OK);
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<?> getShowById(@PathVariable Long id) {
		return new ResponseEntity<Show>(showRepository.find(id), HttpStatus.OK);
	}
	
	@GetMapping("/shows")
	public ResponseEntity<?> getAllShows() {
		return new ResponseEntity<Map<Long, Show>>(showRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/blockedSeats")
	public ResponseEntity<?> saveBlockedSeats(@RequestBody BlockedSeats blockedSeats) {
		try {
			return new ResponseEntity<BlockedSeats>(blockedSeatsService.save(blockedSeats),  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),  HttpStatus.CONFLICT);
		}
		
	}
	
	@GetMapping("/getAllBlockedSeats")
	public ResponseEntity<?> getAllBlockedSeats() {
		return new ResponseEntity<Iterable<BlockedSeats>>(blockedSeatsService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/blockedSeats/{id}")
	public ResponseEntity<?> getBlockedSeats(@PathVariable String id) {
		return new ResponseEntity<BlockedSeats>(blockedSeatsService.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/blockedSeats/{id}")
	public ResponseEntity<?> delBlockedSeats(@PathVariable String id) {
		blockedSeatsService.delete(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/delBlockedSeats")
	public ResponseEntity<?> delAllblockedSeats() {
		blockedSeatsService.deleteAll();
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
	
	@PostMapping("/blockedSeatsStatus")
	public String seatStatus(@RequestBody BlockedSeats seats) {
		Show show = showRepository.find(seats.getShowId());
		logger.info(seats.toString());
		for(int i:seats.getSeats()) {
			if(show.getSeats().get(i).equals("blocked")) {
				if(seats.getStatus().equals("booked"))
					show.getSeats().put(i, "booked");
				else
					show.getSeats().put(i, "open");
			}
		}
		//blockedSeatsService.delete(seats.getId());
		showRepository.save(show);
		seats.setMovieEventId(show.getMovieEventId());
		MessageChannel messageChannel = bookedSeatsStream.outboundBookedSeats();
		messageChannel.send(MessageBuilder.withPayload(seats)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		String message = "";
		if(seats.getStatus().equals("booked")) {
			message = "Congrats, You have booked Seat No: ";
			for(int i:seats.getSeats()) {
				message+=i+", ";
			}
			message+="for movieEventId: "+show.getMovieEventId();
		} else {
			message+="Your payment is failed for booking seats in movieEventId: "+show.getMovieEventId() + ". Please try again.";
		}
		if(seats.getGuestUserEmailId()!=null||!seats.getGuestUserEmailId().isEmpty()) {
			InputEmailDetails email= new InputEmailDetails();
			email.setEmailAddress(seats.getGuestUserEmailId());
			email.setSubject("Movie Seats Booking");
			email.setBody(message);
			MessageChannel messageChannelEmail = emailStream.outboundEmail();
			messageChannelEmail.send(MessageBuilder.withPayload(email)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		}
		return message;
		
	}
}
