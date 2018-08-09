import { Component, OnInit } from '@angular/core';
import { UserRegistration } from '../user-registration';
import { RegistrationService } from '../registration.service';
@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
  
  userModel = new UserRegistration();
  constructor(private registrationService:RegistrationService) { }
  onSubmit() {
    this.registrationService.saveMovie(this.userModel).subscribe(res => console.log('Saved'));
  }

  ngOnInit() {
  }

}
