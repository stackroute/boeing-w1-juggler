import { Component, OnInit } from '@angular/core';
import{RsvpCreate} from '../RsvpCreate';
import{RsvpInvitation} from '../RsvpInvitation';
import{RsvpInvitationService} from '../rsvp-invitation.service';
import { ActivatedRoute, RouterLink, Router } from '@angular/router';
import {MatRadioModule} from '@angular/material/radio';


import{RsvpCreateService} from '../rsvp-create.service';
@Component({
  selector: 'app-rsvp-eventpage',
  templateUrl: './rsvp-eventpage.component.html',
  styleUrls: ['./rsvp-eventpage.component.css']
})
export class RsvpEventpageComponent implements OnInit {


  rsvpInvitationModel= new RsvpInvitation();
  rsvpModel:any;
  

  constructor(
    private rsvpCreateService:RsvpCreateService,
    private rsvpInvitationService:RsvpInvitationService,
    private activatedRoute:ActivatedRoute
  ,private router:Router
  ) { }

  
  
  ngOnInit() {
    console.log(this.rsvpModel);
   this.rsvpCreateService.getRsvpEventById(8).subscribe(p=>{
     this.rsvpModel=p;
   });
   console.log(this.rsvpModel);
  }

  onSubmit(){console.log("to change status");
  console.log(this.rsvpInvitationModel);
   this.rsvpCreateService.updateRsvp(this.rsvpInvitationModel, 8).subscribe(res=>{console.log('saved')
  });
  
  }
  
 // this.rsvpModel=this.rsvpCreateService.getRsvpEventById(id);

//  getRsvpEventById(id:number){
//  this.rsvpCreateService.getRsvpEventById(id).subscribe(rsvpCreateService=>{
//    this.rsvpModel=rsvpCreateService;
//  });
//  }

 
//  onSubmit(){


//   this.rsvpInvitationService.saveRsvpInvitation(this.rsvpInvitationModel).subscribe(res=>console.log('saved'));
// }
}

