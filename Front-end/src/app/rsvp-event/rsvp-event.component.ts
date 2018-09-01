import { Component, OnInit } from "@angular/core";
import { RsvpCreate } from "../RsvpCreate";
import { RsvpCreateService } from "../rsvp-create.service";
import { Router, ActivatedRoute } from "@angular/router";
@Component({
  selector: "app-rsvp-event",
  templateUrl: "./rsvp-event.component.html",
  styleUrls: ["./rsvp-event.component.css"]
})
export class RsvpEventComponent implements OnInit {
  rsvpModel = new RsvpCreate();
  id: number;
  public dateTime: Date;
  constructor(
    private rsvpCreateService: RsvpCreateService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  onSubmit() {
    this.rsvpModel.userName=localStorage.getItem('currentUser').replace("\"", "").replace("\"", "");
    this.rsvpCreateService.saveRsvpEvent(this.rsvpModel).subscribe(res => {
      console.log("saved");

    // console.log("id of the saved rsvpEvent is ", res.id-118);
      // this.rsvpCreateService.id = res.id;
      
      // // console.log(localStorage.getItem("eventId"));
      
        this.router.navigate(["/"+res.id+"/rsvpInvitation"]);
      
    });
  }


  ngOnInit() {}
}
