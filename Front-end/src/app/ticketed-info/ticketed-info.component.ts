import { Component, OnInit } from '@angular/core';
import { Ticket } from '../models/Ticket';
import { TicketedInfoService} from '../ticketed-info.service';

@Component({
  selector: 'app-ticketed-info',
  templateUrl: './ticketed-info.component.html',
  styleUrls: ['./ticketed-info.component.css']
})
export class TicketedInfoComponent implements OnInit {

  ticketInfo: Ticket;
  ticketInfo1: Ticket;
  event: any;
  User: any;
  url: any;
  result: any;
  constructor(private ticketedInfoObject: TicketedInfoService) { }

  ngOnInit() {
    this.ticketInfo=new Ticket();
    this.event= JSON.parse(localStorage.getItem('movieInfo'));
    console.log("Inside ticketed info "+JSON.stringify(this.event));
    this.User=localStorage.getItem('currentUser');
  }

  eventDescription(){
    //console.log("inside eventDescription()");
    if(this.event.description!=null)
    return true;
    else
    return false;
  }

  bookEvent(){
    this.ticketInfo.ticketedEventId = this.event.id;
    this.ticketInfo.userName= this.User;
    this.ticketInfo.noOfSeats= 1;
    
    this.ticketedInfoObject.sendTicketedInfo(this.ticketInfo).subscribe(r=>{
      console.log("inside service of sendTicketedInfo")
    })
  }

}
