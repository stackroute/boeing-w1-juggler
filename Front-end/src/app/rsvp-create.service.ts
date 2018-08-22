import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RsvpCreate } from './RsvpCreate';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RsvpCreateService {

  private _url: string="http://172.23.238.218:8092/api/v1/rsvpEvent";
  private _url1: string="http://172.23.238.218:8092/api/v1/rsvpEvents";
  private _url2: string="http://172.23.238.218:8092/api/v1/rsvpEvent";

  rsvpCreate:RsvpCreate;
  constructor(private http:HttpClient) { }

  saveRsvpEvent(rsvpCreate:RsvpCreate):Observable<RsvpCreate>
  {
    return this.http.post<RsvpCreate>("http://172.23.238.220:8094/api/v1/upstream/rsvpEvent",rsvpCreate);
  }

  getAllRsvpEvents(): Observable<RsvpCreate[]>{
    return this.http.get<RsvpCreate[]>(this._url1);
  }

getRsvpEventById(id):Observable<RsvpCreate>
{
  return this.http.get<RsvpCreate>(this._url2+id);
}

  deleteRsvp(id){
    return this.http.delete(this._url2+id);
  }

  

}
