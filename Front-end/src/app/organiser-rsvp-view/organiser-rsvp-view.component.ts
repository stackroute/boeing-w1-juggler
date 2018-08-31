import { Component, OnInit } from '@angular/core';
import{RsvpCreate} from '../RsvpCreate';
import{RsvpInvitation} from '../RsvpInvitation';
import{RsvpInvitationService} from '../rsvp-invitation.service';
import{RsvpCreateService} from '../rsvp-create.service';
import { ActivatedRoute, RouterLink, Router } from '@angular/router';
import { InputEmailsDetails } from "../InputEmailsDetails";

@Component({
  selector: 'app-organiser-rsvp-view',
  templateUrl: './organiser-rsvp-view.component.html',
  styleUrls: ['./organiser-rsvp-view.component.css']
})
export class OrganiserRsvpViewComponent implements OnInit {

  rsvpInvitationModel= new RsvpInvitation();
  rsvpModel:any;
  inputEmailsDetails = new InputEmailsDetails();
  

  constructor(
    private rsvpCreateService:RsvpCreateService,
    private rsvpInvitationService:RsvpInvitationService,
    private activatedRoute:ActivatedRoute
  ,private router:Router
  ) { }

  id:any;

  ngOnInit() {
    // this.id=this.rsvpCreateService.getRsvpEventId();
  //  this.id = this.rsvpCreateService.id;
   // console.log("bhaiiii", this.id);
    
    console.log("event id is ",localStorage.getItem("eventId"));
    console.log("rsvp id is ",localStorage.getItem("RSVPId"));
    this.id=localStorage.getItem("RSVPId")
    console.log("id coming",this.id);
    
    

    console.log("this.rsvpModel");
    
    //  console.log(this.rsvpModel);
    this.rsvpCreateService
      .getRsvpEventById(this.id)
      .subscribe(rsvpCreateService => {
        this.rsvpModel = rsvpCreateService;
        console.log(this.rsvpModel);
      });
    console.log("something", this.rsvpModel);
  }

  onSubmit1() {
    //this.id=this.rsvpModel.id;
    console.log("vishal ppuuu");
    // this.router.navigate(["/rsvpEvent/" + this.id]);
    this.router.navigate(["InviteeDetails"]);
  }
  onSubmit2() {
    //this.id=this.rsvpModel.id;
    console.log("vishal ppuuu");
    // this.router.navigate(["/rsvpEvent/" + this.id]);
    this.router.navigate(["rsvpInvitation"]);
  }
}
