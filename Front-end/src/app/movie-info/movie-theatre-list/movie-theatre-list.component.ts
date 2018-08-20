import { Component, OnInit, Input } from '@angular/core';
import { MovieInfoService } from '../../movie-info.service';
import {SearchDataService} from "../../search-data.service";

@Component({
  selector: 'app-movie-theatre-list',
  templateUrl: './movie-theatre-list.component.html',
  styleUrls: ['./movie-theatre-list.component.css']
})
export class MovieTheatreListComponent implements OnInit {
  
  public movie;
  public id;

  constructor(private _movieService : MovieInfoService, private _searchDataService:SearchDataService){
  }
  ngOnInit() {
    this._searchDataService.currentMessage.subscribe(id => this.id = id)
    console.log("print in child" , this.id);
    this._movieService.getMovieById(this.id).subscribe(data=> this.movie=data);
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