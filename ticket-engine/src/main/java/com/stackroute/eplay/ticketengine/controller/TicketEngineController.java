package com.stackroute.eplay.ticketengine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
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

import com.stackroute.eplay.ticketengine.domain.BlockedSeats;
import com.stackroute.eplay.ticketengine.domain.Show;
import com.stackroute.eplay.ticketengine.repository.ShowRepository;
import com.stackroute.eplay.ticketengine.service.BlockedSeatsService;
import com.stackroute.eplay.ticketengine.streams.BookedSeatsStream;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
@EnableBinding(BookedSeatsStream.class)
public class TicketEngineController {
	
	private ShowRepository showRepository;
	private BlockedSeatsService blockedSeatsService;
	private BookedSeatsStream bookedSeatsStream;
	
	@Autowired
	TicketEngineController(ShowRepository showRepository, BlockedSeatsService blockedSeatsService, BookedSeatsStream bookedSeatsStream){
		this.showRepository = showRepository;
		this.blockedSeatsService = blockedSeatsService;
		this.bookedSeatsStream = bookedSeatsStream;
	}
	
	@MessageMapping("/send/message")
    //@SendTo("/chat")
    public BlockedSeats seats(BlockedSeats seats) throws Exception {
		System.out.println(seats);
		
		// return new Show("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
		return blockedSeatsService.save(seats);
    }
	
	@PostMapping("/show")
	public ResponseEntity<?> saveShow(@RequestBody Show show) {
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
	public void seatStatus(@RequestBody BlockedSeats seats) {
		Show show = showRepository.find(seats.getShowId());
		for(int i:seats.getSeats()) {
			if(show.getSeats().get(i).equals("blocked")) {
				if(seats.getStatus()=="booked")
					show.getSeats().put(i, "booked");
				else
					show.getSeats().put(i, "open");
			}
		}
		blockedSeatsService.delete(seats.getId());
		showRepository.save(show);
		seats.setMovieEventId(show.getMovieEventId());
		MessageChannel messageChannel = bookedSeatsStream.outboundBookedSeats();
		messageChannel.send(MessageBuilder.withPayload(seats)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
	}
}
