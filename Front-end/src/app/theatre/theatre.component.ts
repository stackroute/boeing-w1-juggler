import { Component, OnInit } from '@angular/core';
import { Theatre } from '../theatre';
import { TheatreService } from "../theatre.service";
@Component({
  selector: 'app-theatre',
  templateUrl: './theatre.component.html',
  styleUrls: ['./theatre.component.css']
})
export class TheatreComponent implements OnInit {
  theatreModel = new Theatre();
  constructor(private theatreService :TheatreService) { }
  onSubmit() {
    this.theatreService
      .saveTheatre(this.theatreModel)
      .subscribe(res => console.log("Saved theatre"));
  }
  ngOnInit() {
  }

}
