import { Component, OnInit } from "@angular/core";
import { FormControl } from "@angular/forms";
@Component({
  selector: "app-movie-event",
  templateUrl: "./movie-event.component.html",
  styleUrls: ["./movie-event.component.css"]
})
export class MovieEventComponent implements OnInit {
  movieEventControl = new FormControl();
  theatreGroups: TheatreGroup[] = [
    {
      name: "PVR",
      theatre: [
        { value: "PVR INOX", viewValue: "PVR Kormangla" },
        { value: "PVR GOLDCLASS", viewValue: "PVR Orion Mall" },
        { value: "PVR FAMILY", viewValue: "PVR Arena Mall" }
      ]
    },
    {
      name: "Imax",
      theatre: [
        { value: "Imax Gold", viewValue: "Imax Mantri Mall" },
        { value: "Imax Silver", viewValue: "Imax Forum" },
        { value: "Imax Platinum", viewValue: "Imax Phoenix marketcity" }
      ]
    },
    {
      name: "Wave",
      // disabled: true,
      theatre: [
        { value: "Wave red", viewValue: "Wave red" },
        { value: "Wave Gold", viewValue: "Wave Gold" },
        { value: "Wave Balcony", viewValue: "Wave Balcony" }
      ]
    }
  ];

  constructor() {}

  ngOnInit() {}
}

export interface Theatre {
  value: string;
  viewValue: string;
}

export interface TheatreGroup {
  disabled?: boolean;
  name: string;
  theatre: Theatre[];
}
