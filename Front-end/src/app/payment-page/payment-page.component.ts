import { Component, OnInit } from '@angular/core';
import {BlockSeat} from "../models/SeatBlock";
import {PaymentService} from '../payment.service'

@Component({
  selector: 'app-payment-page',
  templateUrl: './payment-page.component.html',
  styleUrls: ['./payment-page.component.css']
})
export class PaymentPageComponent implements OnInit {

  user:any;
  emailId:any;
  paymentStatus:BlockSeat
  constructor(private data :PaymentService ) { }

  ngOnInit() {
    this.paymentStatus=new BlockSeat();
    this.user=localStorage.getItem('currentUser')
    console.log(localStorage.getItem('currentUser'));
  }

  onClickFail(){
    this.data.payMessage.subscribe(message => this.paymentStatus = message)
    console.log("earlier payMessage",this.paymentStatus);
    this.paymentStatus.userName=localStorage.getItem('currentUser');
    this.paymentStatus.guestUserEmailId=this.emailId;
    this.paymentStatus.showId=2;
    this.paymentStatus.status="open";
    console.log("payment staus",this.paymentStatus);
    this.data.sendStatus(this.paymentStatus).subscribe(res=>{console.log('staus posted') })
  }

  onClickSuccess(){
    this.data.payMessage.subscribe(message => this.paymentStatus = message)
    console.log("earlier payMessage",this.paymentStatus);
    this.paymentStatus.userName=localStorage.getItem('currentUser');
    this.paymentStatus.guestUserEmailId=this.emailId;
    this.paymentStatus.showId=2;
    this.paymentStatus.status="booked";
    console.log("payment staus",this.paymentStatus);
    this.data.sendStatus(this.paymentStatus).subscribe(res=>{console.log('staus posted') })
  }

}
