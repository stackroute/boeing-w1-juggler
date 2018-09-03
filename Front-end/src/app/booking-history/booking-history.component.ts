import { Component, OnInit } from '@angular/core';
import { SearchDataService } from "../search-data.service";
import { RegistrationService } from "../registration.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-booking-history',
  templateUrl: './booking-history.component.html',
  styleUrls: ['./booking-history.component.css']
})
export class BookingHistoryComponent implements OnInit {

  movieList: any[];
  yourData: any;
  movie: any;


  constructor(
    private data: SearchDataService,
    private router: Router,
    private userData: RegistrationService
  ) {}
  ngOnInit() {
    this.movieList = [];
    this.userData
      .getUser(localStorage.getItem("currentUser"))
      .subscribe(data => {
        this.yourData = data;
        console.log("your data", data);
        for (var i = 0; i < this.yourData.bookedMovieId.length; i++) {
          console.log("top i is", i);
          this.data
          .getMovieByCitynIduser(
            this.yourData.bookedMovieId[i],localStorage.getItem('city')
          )
          .subscribe(data => {
            this.movie = data;
            this.movieList.push(this.movie);
            
          });
        }
        console.log("booked movies",this.movieList);
      }
)
}
  
}
