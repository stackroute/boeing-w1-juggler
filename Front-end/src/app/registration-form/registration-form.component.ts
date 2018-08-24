import { Component, OnInit } from "@angular/core";
import { UserRegistration } from "../models/user-registration";
import { RegistrationService } from "../registration.service";
import {MatSnackBar} from '@angular/material';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: "app-registration-form",
  templateUrl: "./registration-form.component.html",
  styleUrls: ["./registration-form.component.css"]
})
export class RegistrationFormComponent implements OnInit {
  user= new UserRegistration();
  registerForm: FormGroup;
  hide = true;
  ;

  constructor(private formBuilder: FormBuilder,private registrationService: RegistrationService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      'userName': ["", [
        Validators.required
      ]],
      'email': ["", [
        Validators.required,
        Validators.email
      ]],
      'password': ["", [
        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(30)
      ]]
    });
  }
  // onRegisterSubmit() {
  //   alert(this.user.userName + ' ' + this.user.email + ' ' + this.user.password);
  //  }
  onSubmit() {
    this.registrationService
      .addUser(this.user)
      .subscribe(res => console.log("Saved"));
  }
  get userName() {
    return this.registerForm.get('userName');
  }
}