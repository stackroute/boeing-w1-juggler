import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import {BlockSeat} from "./models/SeatBlock";
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private pay = new BehaviorSubject(new BlockSeat());
  payMessage = this.pay.asObservable();

 changePayMessage(message: BlockSeat) {
  this.pay.next(message)
}
  constructor(private http:HttpClient) { }
  sendStatus(status: BlockSeat){
    console.log("final pay status",status);
    //return this.http.post<string>('http://13.232.40.6:8092/ticket-engine/api/v1/blockedSeatsStatus',status);
    (window as any).sendBlockedSeats(status);
  }
}
