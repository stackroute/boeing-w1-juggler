import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { TicketedEvent } from './ticketedEvent';
@Injectable({
  providedIn: 'root'
})
export class TicketedEventService {

  private _url: string = "http://172.23.238.220:8080/api/v1/upstream";
  constructor(private http: HttpClient) { }
  saveTicketedEvent(ticketedEvent : TicketedEvent){
    return this.http.post<TicketedEvent>(this._url+"/ticketedEvent", ticketedEvent);
  }
}