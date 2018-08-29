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

  constructor(
    private rsvpCreateService: RsvpCreateService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  onSubmit() {
    this.rsvpCreateService.saveRsvpEvent(this.rsvpModel).subscribe(res => {
      console.log("saved");

     // console.log("id of the saved rsvpEvent is ", res.id-118);
      // this.rsvpCreateService.id = res.id;
      console.log("id of the saved rsvpEvent is ", res.id);

      //localStorage.setItem("eventId", JSON.stringify(res.id-118));
      // console.log(localStorage.getItem("eventId"));
      this.router.navigate(["/rsvpInvitation"]);
      
    });
  }

  ngOnInit() {}
}
