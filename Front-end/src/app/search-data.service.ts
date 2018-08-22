import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import{Router} from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { Movie } from './movie';

@Injectable({
 providedIn: 'root'
})

export class SearchDataService {

 private messageSource = new BehaviorSubject('default message');
 currentMessage = this.messageSource.asObservable();

 changeMessage(message: string) {
  this.messageSource.next(message)
}

 private movie = new BehaviorSubject(new Movie());
 movieMessage = this.movie.asObservable();

 changeMovieMessage(message: Movie) {
  this.movie.next(message)
}

 
 constructor(private http: HttpClient, private router: Router) { }
 getMyEvents(city) {
   return this.http.get('http://172.23.238.198:8092/search-service/api/v1/city/'+city)
 }
 getAllMovies() {
  return this.http.get('http://172.23.238.198:8092/search-service/api/v1/movies')
}
 getSearchedEvents(name) {
   console.log(name);
  return this.http.get('http://172.23.238.198:8092/search-service/api/v1/movies/'+name)
}

getMovieByCitynId(movieId) {
  let city=localStorage.getItem('city');
   return this.http.get('http://172.23.238.198:8092/search-service/api/v1/movie/'+movieId+'/city/'+city)
  }

}