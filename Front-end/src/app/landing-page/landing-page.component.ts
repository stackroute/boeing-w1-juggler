import { Component, OnInit } from "@angular/core";
import { SearchDataService } from "../search-data.service";

@Component({
  selector: "app-landing-page",
  templateUrl: "./landing-page.component.html",
  styleUrls: ["./landing-page.component.css"]
})
export class LandingPageComponent implements OnInit {
  message: string;
  constructor(private data: SearchDataService) {}
  ngOnInit() {}
  onclick1() {
    localStorage.setItem("city", "Delhi");
  }
  onclick2() {
    localStorage.setItem("city", "Mumbai");
  }
  onclick3() {
    localStorage.setItem("city", "Bangalore");
  }
  onclick4() {
    localStorage.setItem("city", "Hyderabad");
  }
  onclick5() {
    localStorage.setItem("city", "Kolkata");
  }
  onclick6() {
    localStorage.setItem("city", "Chennai");
  }
  onclick7() {
    localStorage.setItem("city", "Pune");
  }
  onclick8() {
    localStorage.setItem("city", "Ahmedabad");
  }
}
