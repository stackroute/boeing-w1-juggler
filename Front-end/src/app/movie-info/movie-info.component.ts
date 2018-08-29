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

  }

  ngOnInit() {
    this.movies=JSON.parse(localStorage.getItem('movieInfo'));
    this._searchDataService.movieMessage.subscribe(movie => this.movie = movie);
    console.log("my theatre",this.movie);
  }
}