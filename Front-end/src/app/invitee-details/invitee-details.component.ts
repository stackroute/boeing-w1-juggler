import { Component, OnInit } from "@angular/core";
import { RsvpInvitation } from "../RsvpInvitation";
import { RsvpInvitationService } from "../rsvp-invitation.service";
import { ActivatedRoute, RouterLink, Router } from "@angular/router";
import { RsvpCreate } from "../RsvpCreate";
import { RsvpCreateService } from "../rsvp-create.service";
import { InputEmailsDetails } from "../InputEmailsDetails";
import { EmailService } from "../email.service";

@Component({
  selector: "app-invitee-details",
  templateUrl: "./invitee-details.component.html",
  styleUrls: ["./invitee-details.component.css"]
})
export class InviteeDetailsComponent implements OnInit {
  rsvpInvitationModel = new RsvpInvitation();
  inputEmailsDetails = new InputEmailsDetails();
  public rsvpModel: any;
  message: string;

  id: any;
  constructor(
    private emailService: EmailService,
    private rsvpCreateService: RsvpCreateService,
    private rsvpInvitationService: RsvpInvitationService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    console.log("this.rsvpModel");
    this.id = this.rsvpCreateService.getRsvpEventId;
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
  onSubmit1() {
    this.id = this.rsvpCreateService.getRsvpEventId;
    console.log("vishal ppuuu");
    this.router.navigate(["/rsvpEvent/" + this.id]);
    // this.router.navigate(["InviteeDetails"]);
  }
}
