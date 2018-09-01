import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Ticket} from './models/Ticket';
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TicketedInfoService {

  private url: string = "http://13.232.40.6:8092/ticket-service/ticket-service/api/v1/bookTicketedEvent";
  constructor(private http: HttpClient) {}


  sendTicketedInfo(ticketInfo: Ticket): Observable<Ticket>{
    console.log(ticketInfo);
    return this.http.put<Ticket>(this.url,ticketInfo);
  }

}
