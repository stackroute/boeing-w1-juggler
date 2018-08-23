import { Component, OnInit } from "@angular/core";
import { SearchDataService } from "../search-data.service";
import { Router } from "@angular/router";

@Component({
 selector: "app-home-page",
 templateUrl: "./home-page.component.html",
 styleUrls: ["./home-page.component.css"]
})
export class HomePageComponent implements OnInit {
 event$: any;
 message:string;
 rec$:any;
 constructor(
   private data: SearchDataService,
   private router: Router,
 ) {}
 ngOnInit() {
   this.data.currentMessage.subscribe(message => this.message = message)
   this.fetchEvents();
   this.rec$=JSON.parse(localStorage.getItem('rec'));
 }
 fetchEvents(){
   console.log("Hi fetchMovies is called ", this.message);
   this.data.getMyEvents(this.message).subscribe(data => {
     this.event$ = data;
     console.log(data);
   });
 }
 goMoviePage(movie){
  this.data.changeMovieMessage(movie);
  console.log(movie);

}
}