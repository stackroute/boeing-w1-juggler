import { Component, OnInit } from '@angular/core';
import{RsvpInvitation} from '../RsvpInvitation';
import{RsvpInvitationService} from '../rsvp-invitation.service';
import { ActivatedRoute, RouterLink, Router } from '@angular/router';
import{RsvpCreate} from '../RsvpCreate';
import{RsvpCreateService} from '../rsvp-create.service';
@Component({
  selector: 'app-rsvp-invitation',
  templateUrl: './rsvp-invitation.component.html',
  styleUrls: ['./rsvp-invitation.component.css']
})
export class RsvpInvitationComponent implements OnInit {

  rsvpInvitationModel= new RsvpInvitation;
  rsvpModel=new RsvpCreate;
  id;
  constructor(private rsvpCreateService:RsvpCreateService,
    private rsvpInvitationService:RsvpInvitationService,
    private activatedRoute:ActivatedRoute
  ,private router:Router
  ) { }

  onSubmit(){
    this.rsvpInvitationService.saveRsvpInvitation(this.rsvpInvitationModel).subscribe(res=>console.log('saved'));
  }


  onSubmit1(){
    this.id=this.rsvpModel.id;
    this.router.navigate(['/rsvpEvent/'+this.id]);
    
  }


  ngOnInit() {
   
  }



}
