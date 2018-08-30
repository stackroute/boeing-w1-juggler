import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';
@Component({
  selector: 'app-movie-info',
  templateUrl: './movie-info.component.html',
  styleUrls: ['./movie-info.component.css']
})
export class MovieInfoComponent implements OnInit {
   movie;
   movies: any;
   recommendedMovies:any
  constructor(private _searchDataService:SearchDataService) {
    this.movies=JSON.parse(localStorage.getItem('movieInfo'));
    // this.recommendedMovies = JSON.parse(localStorage.getItem('recommended'));
    console.log(this.movies);

  }

  ngOnInit() {
    this.movies=JSON.parse(localStorage.getItem('movieInfo'));
    console.log("movies are " + JSON.stringify(this.movies));
    this.recommendedMovies = JSON.parse(localStorage.getItem('recommended'))
    console.log(" some recommended given movies",this.recommendedMovies);
    this._searchDataService.movieMessage.subscribe(movies => this.movie = movies);
    console.log("my theatre",this.movie);
  }

  movieDescription(){
    console.log("inside movie description");
    console.log(this.movies);
    if(this.movies.description!=null)
    return true;
    else
    return false;
  }
}