import { Component, OnInit } from "@angular/core";
import { FormControl } from "@angular/forms";
import { MovieEvent } from "../movie-event";
import { MovieEventService } from "../movie-event.service";
import { SearchDataService } from "../search-data.service";
import { Movie } from "../models/movie";
@Component({
  selector: "app-movie-event",
  templateUrl: "./movie-event.component.html",
  styleUrls: ["./movie-event.component.css"]
})
export class MovieEventComponent implements OnInit {
  movieEventModel = new MovieEvent();
  movieEventControl = new FormControl();
  movies:Movie[];

  movieId; // ID corresponding to selected movie Name from Dropdown
 
  constructor(private movieEventService :MovieEventService,private _searchDataService:SearchDataService) {}
  
  ngOnInit() {
    this._searchDataService.getAllMovies().subscribe(data => this.movies = data);
    console.log("my movies",this.movies);
  }

  findId(n){
    console.log(n.id);
  this.movieEventModel.movieId=n.id;
  this.movieEventModel.city='delhi';
  }
  onSubmit() {
    console.log(this.movieEventModel);
    this.movieEventService
      .saveMovieEvent(this.movieEventModel)
      .subscribe(res => console.log("Saved Movie Event"));
  }

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
