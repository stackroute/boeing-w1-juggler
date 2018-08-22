import { Component } from "@angular/core";
import { AuthenticationService } from "./authentication.service";

declare var test: any;
@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = "E-Play";

  constructor(private authenticationService: AuthenticationService){}
  f(){
    new test();
  }
}
