import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import{Router} from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Injectable({
 providedIn: 'root'
})

export class SearchDataService {

 private messageSource = new BehaviorSubject('default message');
 currentMessage = this.messageSource.asObservable();


 changeMessage(message: string) {
   this.messageSource.next(message)
 }
 constructor(private http: HttpClient, private router: Router) { }
 getMyEvents(city) {
   return this.http.get('http://172.23.238.221:8093/api/v1/city/'+city)
 }
 getAllMovies() {
  return this.http.get('http://172.23.238.221:8093/api/v1/movies')
}
 getSearchedEvents(name) {
   console.log(name);
  return this.http.get('http://172.23.238.221:8093/api/v1/movie/'+name)
}
}