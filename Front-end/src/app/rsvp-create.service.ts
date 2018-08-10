import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RsvpCreate } from './RsvpCreate';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RsvpCreateService {

  private _url: string="http://localhost:8080/api/v1/rsvpEvent";
  private _url1: string="http://localhost:8080/api/v1/rsvpEvents";
  private _url2: string="http://localhost:8080/api/v1/rsvpEvent";


  constructor(private http:HttpClient) { }

  saveRsvpEvent(rsvpCreate:RsvpCreate):Observable<RsvpCreate>
  {
    return this.http.post<RsvpCreate>(this._url,rsvpCreate);
  }

  getAllRsvpEvents(): Observable<RsvpCreate[]>{
    return this.http.get<RsvpCreate[]>(this._url1);
  }

  deleteRsvp(id){
    return this.http.delete(this._url2+id);
  }

  

}
