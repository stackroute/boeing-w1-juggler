import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Movie } from "./movie";
@Injectable({
  providedIn: 'root'
})
export class RecommendationService {
  private url :string ="http://172.23.238.175:8098/api/v1";

  constructor(private http: HttpClient) { }

  getMoviesByGenre(name:string):Observable<Movie[]>{
    console.log("inside getmovies by genre")
    return this.http.get<Movie[]>(this.url+"/getMoviesByGenre?genreName="+name);
  }
}
