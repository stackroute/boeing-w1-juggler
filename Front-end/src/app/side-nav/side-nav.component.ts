import { Component, OnInit } from '@angular/core';
import { Movie } from "../movie";
import { RecommendationService } from '../recommendation.service';
@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent implements OnInit {
  
  movies:Movie[];
  moviegenre;
  constructor(private recommendationservice:RecommendationService) { }

  onChange(genre:string) {
    console.log("inside onchange start");
    this.recommendationservice.getMoviesByGenre(genre)    
      .subscribe(res => {
        this.moviegenre= res;
      });
      console.log(genre);

      console.log(this.moviegenre);
     this.movies.push(this.moviegenre);
    //  console.log("inside onchange");
    //  console.log(this.movies);
 }
  ngOnInit() {
  }

}
