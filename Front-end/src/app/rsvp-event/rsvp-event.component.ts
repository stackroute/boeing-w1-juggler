import { Component, OnInit } from '@angular/core';
import{RsvpCreate} from '../RsvpCreate';
@Component({
  selector: 'app-rsvp-event',
  templateUrl: './rsvp-event.component.html',
  styleUrls: ['./rsvp-event.component.css']
})
export class RsvpEventComponent implements OnInit {


  rsvpModel=new RsvpCreate;
  constructor() { }

  ngOnInit() {
  }

}
