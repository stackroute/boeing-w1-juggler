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
  id:number;

  constructor(
    private rsvpCreateService: RsvpCreateService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  onSubmit(){
    

     this.rsvpModel.userName=localStorage.getItem('currentUser').replace("\"", "").replace("\"", "");
     console.log(this.rsvpModel);
    this.rsvpCreateService.saveRsvpEvent(this.rsvpModel).subscribe(res=>{console.log('saved')
    
  })
  }

  ngOnInit() {}
}
