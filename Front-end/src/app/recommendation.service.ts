import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Movie } from "./movie";

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {
  private url :string ="http://13.232.40.6:8098/api/v1";
  private urlCityGenre; 
  genreNames;
  
  constructor(private http: HttpClient) { }

  getMoviesByGenre(name:string, genreNames):Observable<Movie[]>{
    console.log("inside getmovies by genre");
   
    this.urlCityGenre=this.url+"/getMoviesByCityAndGenres?name="+localStorage.getItem('city'); 

    for(let genreName in genreNames){
      console.log(genreNames[genreName].moviegenre);
      this.urlCityGenre = this.urlCityGenre+"&genreNames="+genreNames[genreName].moviegenre;
    }

    console.log(this.urlCityGenre);
     localStorage.removeItem('rec');
    return this.http.get<Movie[]>(this.urlCityGenre);
  }
}
