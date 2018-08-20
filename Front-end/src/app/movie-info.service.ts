import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieInfoService {

  constructor(private http: HttpClient) { }
  
  getMovieById(id){
    return this.http.get('http://172.23.238.221:8093/api/v1/movieById' + id);
  }
}