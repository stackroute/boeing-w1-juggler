import { Component, OnInit } from '@angular/core';
import{RsvpCreate} from '../RsvpCreate';
import{RsvpInvitation} from '../RsvpInvitation';
import{RsvpInvitationService} from '../rsvp-invitation.service';
import { ActivatedRoute, RouterLink, Router } from '@angular/router';

import{RsvpCreateService} from '../rsvp-create.service';
@Component({
  selector: 'app-rsvp-eventpage',
  templateUrl: './rsvp-eventpage.component.html',
  styleUrls: ['./rsvp-eventpage.component.css']
})
export class RsvpEventpageComponent implements OnInit {


  rsvpInvitationModel= new RsvpInvitation;
  rsvpModel=new RsvpCreate;
  id:number;
  constructor(private rsvpCreateService:RsvpCreateService,
    private rsvpInvitationService:RsvpInvitationService,
    private activatedRoute:ActivatedRoute
  ,private router:Router
  ) { }
  
  ngOnInit() {
  }

}
