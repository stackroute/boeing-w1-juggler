import { Component, OnInit } from "@angular/core";
import { RsvpInvitation } from "../RsvpInvitation";
import { RsvpInvitationService } from "../rsvp-invitation.service";
import { ActivatedRoute, RouterLink, Router } from "@angular/router";
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
 id = 3;
 id1: string;
 idd = this.id.toString();
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
   console.log("this.rsvpModel");
   this.inputEmailsDetails.emailBcc = [];
   //  console.log(this.rsvpModel);
   this.rsvpCreateService.getRsvpEventById(3).subscribe(rsvpCreateService => {
     this.rsvpModel = rsvpCreateService;
     console.log(this.rsvpModel);
   });
   console.log("something", this.rsvpModel);
 }
 onSubmit() {
   console.log("vishal ppu");
   console.log(this.rsvpInvitationModel);
   this.rsvpCreateService
     .updateRsvp(this.rsvpInvitationModel, 3)
     .subscribe(res => {
       console.log("saved");
     });
   location.reload();
 }
 onSubmit1() {
   //this.id=this.rsvpModel.id;
   console.log("vishal ppuuu");
  // this.router.navigate(["/rsvpEvent/" + this.id]);
  this.router.navigate(["InviteeDetails"]);
 }

 onSubmit2() {
   this.inputEmailsDetails.emailAddress = "aerospacevishal@gmail.com";
   this.inputEmailsDetails.subject =
     "You are invited to: " + this.rsvpModel.name;
   this.inputEmailsDetails.body ="click here to view Invitation http://172.23.238.188:4200/rsvpEvent/3";


   for (var i=0;i<(this.rsvpModel.rsvpInvitation).length;i++)
     {
       this.inputEmailsDetails.emailBcc.push(
         this.rsvpModel.rsvpInvitation[i].inviteeEmail
       );
     }
     console.log("bhai kha ahi",this.inputEmailsDetails);
     
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