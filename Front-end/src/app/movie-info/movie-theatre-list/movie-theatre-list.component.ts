import { Component, OnInit, Input } from '@angular/core';
import {SearchDataService} from "../../search-data.service";

@Component({
  selector: 'app-movie-theatre-list',
  templateUrl: './movie-theatre-list.component.html',
  styleUrls: ['./movie-theatre-list.component.css']
})
export class MovieTheatreListComponent implements OnInit {
  
  public movie;

  constructor(private _searchDataService:SearchDataService){
  }
  ngOnInit() {
    this._searchDataService.movieMessage.subscribe(movie => this.movie = movie)
    console.log("print in child" , this.movie);
    //this._movieService.getMovieById(this.id).subscribe(data=> this.movie=data);
  } 

  shows=[
    {
      showTime:'10:10am'
    },
    {
      showTime:'10:20am'
    },
    {
      showTime:'10:30am'
    }
  ]

  theatreList=[
    {
      name:'PVR',
      location:'Kormangala'
    },
    {
      name:'Srinivasa',
      location:'Kormangala'
    },
    {
      name:'IMAX',
      location:'Indira Nagar'
    },
    {
      name:'Odeon',
      location:'MG Road'
    },
    {
      name:'Galaxy',
      location:'Shanti Nagar'
    }
  ]
}