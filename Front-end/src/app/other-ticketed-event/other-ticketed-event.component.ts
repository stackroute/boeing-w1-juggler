import { Component, OnInit } from "@angular/core";
import { FormControl } from "@angular/forms";
import { TicketedEvent } from "../ticketedEvent";
import { TicketedEventService } from "../ticketed-event.service";
@Component({
  selector: "app-other-ticketed-event",
  templateUrl: "./other-ticketed-event.component.html",
  styleUrls: ["./other-ticketed-event.component.css"]
})
export class OtherTicketedEventComponent implements OnInit {
  otherTicketedEventControl = new FormControl();
  otherTicketedEventControl1 = new FormControl();
  ticketedEvent = new TicketedEvent();
  constructor(private ticketedEventService: TicketedEventService) {}
  submitTicketedEvent() {
    this.ticketedEventService
      .saveTicketedEvent(this.ticketedEvent)
      .subscribe(res => console.log("Saved"));
  }


  typegroup: TypeGroup[] = [
    {
      name: "Event Types",
      type: [
        { value: "Plays", viewValue: "Plays" },
        { value: "Comedy", viewValue: "Comedy" },
        { value: "Music", viewValue: "Music" },
        { value: "Rockshow", viewValue: "Concerts" },
        { value: "Sports", viewValue: "Sports" },
        
      ]
    }
  ];

  ngOnInit() {}
}

export interface City {
  value: string;
  viewValue: string;
}



export interface Type {
  value: string;
  viewValue: string;
}

export interface TypeGroup {
  disabled?: boolean;
  name: string;
  type: Type[];
}

