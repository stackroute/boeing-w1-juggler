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
  id=78;
  constructor(private rsvpCreateService:RsvpCreateService,
    private rsvpInvitationService:RsvpInvitationService,
    private activatedRoute:ActivatedRoute
  ,private router:Router
  ) { }
  ngOnInit() {
    console.log("visha");
   }
  onSubmit(){console.log("vishal ppu");
  console.log(this.rsvpInvitationModel);
   this.rsvpCreateService.updateRsvp(this.rsvpInvitationModel,78).subscribe(res=>{console.log('saved')
  });

  }
  onSubmit1(){
    //this.id=this.rsvpModel.id;
    console.log("vishal ppuuu");
    this.router.navigate(['/rsvpEvent/'+this.id]);
    
  }


 

  // onSubmit2(){
  //   this.rsvpInvitationService.saveRsvpInvitation(this.rsvpInvitationModel).subscribe(res=>console.log('saved'));
   
  //   this.rsvpModel.rsvpInvitationList.push(this.rsvpInvitationModel);
  //   this.rsvpCreateService.updateRsvp(this.id,this.rsvpModel).subscribe(rsvpCreateService=>{
  //     this.rsvpModel=rsvpCreateService;
  //   });
  // }

}
