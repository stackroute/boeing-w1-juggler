import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';
@Component({
  selector: 'app-movie-info',
  templateUrl: './movie-info.component.html',
  styleUrls: ['./movie-info.component.css']
})
export class MovieInfoComponent implements OnInit {
  public movie;
  constructor(private _searchDataService:SearchDataService) {}

  ngOnInit() {
    this._searchDataService.movieMessage.subscribe(movie => this.movie = movie);
    console.log("my theatre",this.movie);
  }
}