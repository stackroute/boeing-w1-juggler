import { Component, OnInit, Input } from '@angular/core';
import {SearchDataService} from "../../search-data.service";

@Component({
  selector: 'app-movie-theatre-list',
  templateUrl: './movie-theatre-list.component.html',
  styleUrls: ['./movie-theatre-list.component.css']
})
export class MovieTheatreListComponent implements OnInit {
  
  public movie;
  public theatreList;
  public movieRecommend;

  constructor(private _searchDataService:SearchDataService){
  }
  ngOnInit() {
    this._searchDataService.movieMessage.subscribe(movie => this.movie = movie)
    this.movie=JSON.parse(localStorage.getItem('movieInfo'));
    console.log("print in child" , this.movie);
    this.theatreList= this.movie.theatres;
    this.theatreList=this.theatreList[0];
    this._searchDataService.getMovieByCitynId(this.movie.id).subscribe(movieRecommend => this.movieRecommend = movieRecommend)
  }

  sendShowId(id){
    localStorage.setItem('showId',id);
  }
}