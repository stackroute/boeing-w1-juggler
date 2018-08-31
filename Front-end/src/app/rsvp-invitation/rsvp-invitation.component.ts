import { Component, OnInit } from "@angular/core";
import { RsvpInvitation } from "../RsvpInvitation";
import { RsvpInvitationService } from "../rsvp-invitation.service";
import { ActivatedRoute, RouterLink, Router, ParamMap } from "@angular/router";
import { RsvpCreate } from "../RsvpCreate";
import { RsvpCreateService } from "../rsvp-create.service";
import { InputEmailsDetails } from "../InputEmailsDetails";
import { EmailService } from "../email.service";
@Component({
  selector: "app-rsvp-invitation",
  templateUrl: "./rsvp-invitation.component.html",
  styleUrls: ["./rsvp-invitation.component.css"]
})
export class RsvpInvitationComponent implements OnInit {
  rsvpInvitationModel = new RsvpInvitation();
  inputEmailsDetails = new InputEmailsDetails();
  public rsvpModel: any;
  message: string;
  id;
  finalId;

  // backgroundImg;
  constructor(
    private emailService: EmailService,
    private rsvpCreateService: RsvpCreateService,
    private rsvpInvitationService: RsvpInvitationService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    // this.backgroundImg rsvpCreateService= sanitizer.bypassSecurityTrustStyle('url(http://www.freephotos.se/images/photos_medium/white-flower-4.jpg)');
  }
  ngOnInit() {
    // this.id=this.rsvpCreateService.getRsvpEventId();
  //  this.id = this.rsvpCreateService.id;
   // console.log("bhaiiii", this.id);
   this.activatedRoute.paramMap.subscribe((param: ParamMap)=>this.finalId=parseInt(param.get('id')));
   console.log("jysgciuwhgckw "+this.finalId); 
   console.log("event id is ",localStorage.getItem("eventId"));
    console.log("rsvp id is",localStorage.getItem("RSVPId"));
    
    if(localStorage.getItem("RSVPId")==null||localStorage.getItem("RSVPId")=="-1")
    {
      this.id=localStorage.getItem("eventId");
    }
    else{
    this.id=localStorage.getItem("RSVPId");
    console.log("id coming",this.id);
  }
    


    console.log("this.rsvpModel");
    this.inputEmailsDetails.emailBcc = [];
    //  console.log(this.rsvpModel);
    this.rsvpCreateService
      .getRsvpEventById(this.id)
      .subscribe(rsvpCreateService => {
        this.rsvpModel = rsvpCreateService;
        console.log(this.rsvpModel);
      });
    console.log("something", this.rsvpModel);
  }
  onSubmit() {
    this.id=localStorage.getItem("eventId");
    console.log("vishal ppu");
    //console.log(this.rsvpInvitationModel);
    this.rsvpCreateService
      .updateRsvp(this.rsvpInvitationModel, this.finalId)
      .subscribe(res => {
        console.log("saved");
      });
      console.log("bhaaaaaai",this.id);
      
       location.reload();
  }
  onSubmit1() {
    //this.id=this.rsvpModel.id;
    console.log("vishal ppuuu");
    // this.router.navigate(["/rsvpEvent/" + this.id]);
    this.router.navigate(["InviteeDetails"]);
  }

  onSubmit2() {
    if(localStorage.getItem("RSVPId")==null||localStorage.getItem("RSVPId")=="-1")
    {
      this.id=localStorage.getItem("eventId");
    }
    else{
    this.id=localStorage.getItem("RSVPId");
    console.log("id coming",this.id);
  }
    this.inputEmailsDetails.emailAddress = "aerospacevishal@gmail.com";
    this.inputEmailsDetails.subject =
      "You are invited to: " + this.rsvpModel.name;
    this.inputEmailsDetails.body =
      "click here to view Invitation http://172.23.238.170:4200/rsvpEvent/" +
      this.id;
    for (var i = 0; i < this.rsvpModel.rsvpInvitation.length; i++) {
      this.inputEmailsDetails.emailBcc.push(
        this.rsvpModel.rsvpInvitation[i].inviteeEmail
      );
    }
    console.log("bhai kha ahi", this.inputEmailsDetails);

    //  this.inputEmailsDetails.emailBcc.push(
    //    this.rsvpModel.rsvpInvitation[0].inviteeEmail
    //  );

    //  this.inputEmailsDetails.emailBcc.push(
    //    this.rsvpModel.rsvpInvitation[1].inviteeEmail
    //  );
    this.callTest();
  }

  callTest() {
    console.log("calling7676767667");
    this.emailService
      .sendInvitations(this.inputEmailsDetails)
      .subscribe(res => {
        console.log(res);
      });
  }
}
