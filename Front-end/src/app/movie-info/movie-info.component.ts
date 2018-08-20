import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';
@Component({
  selector: 'app-movie-info',
  templateUrl: './movie-info.component.html',
  styleUrls: ['./movie-info.component.css']
})
export class MovieInfoComponent implements OnInit {
  public id;
  constructor(private _searchDataService:SearchDataService) {}

  ngOnInit() {
    this._searchDataService.currentMessage.subscribe(id => this.id = id);
    console.log("my theatre",this.id);
  }

  movieName="Movie Name";
}