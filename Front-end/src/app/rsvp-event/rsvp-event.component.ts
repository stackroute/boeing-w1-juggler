import { Component, OnInit } from '@angular/core';
import{RsvpCreate} from '../RsvpCreate';
import{RsvpCreateService} from '../rsvp-create.service';
@Component({
  selector: 'app-rsvp-event',
  templateUrl: './rsvp-event.component.html',
  styleUrls: ['./rsvp-event.component.css']
})
export class RsvpEventComponent implements OnInit {


  rsvpModel=new RsvpCreate;
  constructor(private rsvpCreateService:RsvpCreateService) { }

  onSubmit(){
    this.rsvpCreateService.saveRsvpEvent(this.rsvpModel).subscribe(res=>console.log('saved'));
  }

  ngOnInit() {
  }

}
