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
    console.log("final pay staus",status);
    return this.http.post('http://172.23.238.170:9001/api/v1/blockedSeatsStatus',status);

  }
}
