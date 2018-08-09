import { Component, OnInit } from '@angular/core';
import{RsvpInvitation} from '../RsvpInvitation';
@Component({
  selector: 'app-rsvp-invitation',
  templateUrl: './rsvp-invitation.component.html',
  styleUrls: ['./rsvp-invitation.component.css']
})
export class RsvpInvitationComponent implements OnInit {

  rsvpInvitationModel= new RsvpInvitation;

  constructor() { }

  ngOnInit() {
  }

}
