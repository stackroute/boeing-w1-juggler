import { Component, OnInit } from '@angular/core';
import{RsvpInvitation} from '../RsvpInvitation';
import{RsvpInvitationService} from '../rsvp-invitation.service';
import { ActivatedRoute, RouterLink, Router } from '@angular/router';
import{RsvpCreate} from '../RsvpCreate';
import{RsvpCreateService} from '../rsvp-create.service';
import{InputEmailsDetails} from '../InputEmailsDetails';
import { EmailService } from '../email.service';
@Component({
  selector: 'app-rsvp-invitation',
  templateUrl: './rsvp-invitation.component.html',
  styleUrls: ['./rsvp-invitation.component.css']
})
export class RsvpInvitationComponent implements OnInit {

  rsvpInvitationModel= new RsvpInvitation;
  inputEmailsDetails=new InputEmailsDetails;
  rsvpModel=new RsvpCreate;
  message:string;
  id=78;
 id1:string;
  idd=this.id.toString();
 // backgroundImg;
  constructor(private emailService:EmailService,
    
    private rsvpCreateService:RsvpCreateService,
    private rsvpInvitationService:RsvpInvitationService,
    private activatedRoute:ActivatedRoute
  ,private router:Router
  ) {

    
   // this.backgroundImg = sanitizer.bypassSecurityTrustStyle('url(http://www.freephotos.se/images/photos_medium/white-flower-4.jpg)');
  
   }
   ngOnInit() {
    console.log(this.rsvpModel);
   this.rsvpCreateService.getRsvpEventById(78).subscribe(p=>{
     this.rsvpModel=p;
   });
   console.log(this.rsvpModel);
  }
  onSubmit(){console.log("vishal ppu");
  console.log(this.rsvpInvitationModel);
   this.rsvpCreateService.updateRsvp(this.rsvpInvitationModel,78).subscribe(res=>{console.log('saved')
  });
  location.reload();
  
  }
  onSubmit1(){
    //this.id=this.rsvpModel.id;
    console.log("vishal ppuuu");
    this.router.navigate(['/rsvpEvent/'+this.id]);
    
  }

  onSubmit2(){

    this.inputEmailsDetails.emailAddress="aerospacevishal@gmail.com";
    this.inputEmailsDetails.subject="You are invited to RSVP Event name:"+this.rsvpModel.name;
    this.inputEmailsDetails.body="http://172.23.238.218:4200/rsvpEvent/"+this.id.toString;
    this.inputEmailsDetails.emailBcc.push(this.rsvpModel.rsvpInvitationList[0].inviteeEmail);
    this.inputEmailsDetails.emailBcc.push(this.rsvpModel.rsvpInvitationList[1].inviteeEmail);

    this.emailService.sendInvitations(this.inputEmailsDetails); 

  }

 

  // onSubmit2(){
  //   this.rsvpInvitationService.saveRsvpInvitation(this.rsvpInvitationModel).subscribe(res=>console.log('saved'));
   
  //   this.rsvpModel.rsvpInvitationList.push(this.rsvpInvitationModel);
  //   this.rsvpCreateService.updateRsvp(this.id,this.rsvpModel).subscribe(rsvpCreateService=>{
  //     this.rsvpModel=rsvpCreateService;
  //   });
  // }

}
