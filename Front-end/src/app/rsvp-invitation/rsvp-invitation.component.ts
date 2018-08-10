import { Component, OnInit } from '@angular/core';
import{RsvpInvitation} from '../RsvpInvitation';
import{RsvpInvitationService} from '../rsvp-invitation.service';
@Component({
  selector: 'app-rsvp-invitation',
  templateUrl: './rsvp-invitation.component.html',
  styleUrls: ['./rsvp-invitation.component.css']
})
export class RsvpInvitationComponent implements OnInit {

  rsvpInvitationModel= new RsvpInvitation;

  constructor(private rsvpInvitationService:RsvpInvitationService) { }

  onSubmit(){
    this.rsvpInvitationService.saveRsvpInvitation(this.rsvpInvitationModel).subscribe(res=>console.log('saved'));
  }

  ngOnInit() {
  }

}
