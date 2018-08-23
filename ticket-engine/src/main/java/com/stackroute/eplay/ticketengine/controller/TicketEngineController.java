package com.stackroute.eplay.ticketengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.eplay.ticketengine.domain.Show;
import com.stackroute.eplay.ticketengine.repository.ShowRepositoryImpl;

@RestController
@CrossOrigin("*")
//@RequestMapping("api/v1")
public class TicketEngineController {
	
	private ShowRepositoryImpl showRepository;
	
	@Autowired
	TicketEngineController(ShowRepositoryImpl showRepository){
		this.showRepository = showRepository;
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
	
	@MessageMapping("/send/message")
    @SendTo("/chat")
    public String show(String msg) throws Exception {
		// return new Show("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
		return msg;
    }

}
