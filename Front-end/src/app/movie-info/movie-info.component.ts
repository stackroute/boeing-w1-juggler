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
  constructor(private _searchDataService:SearchDataService) {
    this.movies=JSON.parse(localStorage.getItem('movieInfo'));
    console.log(this.movies);

  }

  ngOnInit() {
    this.movies=JSON.parse(localStorage.getItem('movieInfo'));
    this._searchDataService.movieMessage.subscribe(movies => this.movie = movies);
    console.log("my theatre",this.movie);
  }
}