import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ticketed-info',
  templateUrl: './ticketed-info.component.html',
  styleUrls: ['./ticketed-info.component.css']
})
export class TicketedInfoComponent implements OnInit {

  event: any;
  constructor() { }

  ngOnInit() {
    this.event= JSON.parse(localStorage.getItem('movieInfo'));
    //console.log("Inside ticketed info "+JSON.stringify(this.event));
  }

  eventDescription(){
    //console.log("inside eventDescription()");
    if(this.event.description!=null)
    return true;
    else
    return false;
  }

  bookEvent(){
    console.log("Inside bookEvent function");
  }
}
