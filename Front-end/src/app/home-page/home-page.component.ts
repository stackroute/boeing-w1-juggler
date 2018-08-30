import { Component, OnInit } from "@angular/core";
import { SearchDataService } from "../search-data.service";
import { Router } from "@angular/router";
import {  RecommendationService } from "../recommendation.service";
import { AuthenticationService } from "../authentication.service";

@Component({
  selector: "app-home-page",
  templateUrl: "./home-page.component.html",
  styleUrls: ["./home-page.component.css"]
})

export class HomePageComponent implements OnInit {
  items: Array<any>=[];
  event$: any;
  movie$: any;
  message: string;
  rec$: any;
  recommendedMovie:any;
  constructor(private data: SearchDataService, private router: Router, private recommendationService: RecommendationService, private authenticationService:AuthenticationService) {
    this.items=[
      { name :"{{movie.poster}}"}
      // { name :'assets/images/thumb2.jpg'}

    ];
  }
  ngOnInit() {
    this.data.currentMessage.subscribe(message => (this.message = message));
    this.fetchEvents();
    this.rec$ = JSON.parse(localStorage.getItem("rec"));
  }
  fetchEvents() {
    console.log("Hi fetchMovies is called ", this.message);
    this.data.getMyEvents(this.message).subscribe(data => {
      this.event$ = data;
      console.log(data);
    });
    this.data.getMyMovies(this.message).subscribe(data => {
      this.movie$ = data;
      console.log(data);
    });
    this.getGenreBasedMoviesForUser();
  }
  goMoviePage(movie) {
    console.log("inside goMoviePage");
    localStorage.setItem("movieInfo",JSON.stringify(movie));
    console.log(localStorage.getItem("movieInfo"));
    this.data.changeMovieMessage(movie);
    console.log(movie);
  }
  reset() {
    localStorage.removeItem("rec");
    window.location.reload();
  }

  getGenreBasedMoviesForUser(){
   this.recommendationService.getGenreBasedMoviesForUser(localStorage.getItem('currentUser'))
   .subscribe(res=>{
     this.recommendedMovie=res;
   });
  }

  loggedIn(){
   return this.authenticationService.loggedIn();
  }
}
