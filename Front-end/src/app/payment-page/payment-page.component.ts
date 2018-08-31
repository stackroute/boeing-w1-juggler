import { Component, OnInit } from "@angular/core";
import { BlockSeat } from "../models/SeatBlock";
import { PaymentService } from "../payment.service";
import { Observable } from "rxjs";

export interface Tile {
  poster: string;
  cols: number;
  rows: number;
  text: string;
  color: string;
}

@Component({
  selector: "app-payment-page",
  templateUrl: "./payment-page.component.html",
  styleUrls: ["./payment-page.component.css"]
})
export class PaymentPageComponent implements OnInit {
  tiles: Tile[] = [
    {
      text: "Large Salted Popcorn",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020001_13082018125322.jpg",
      color: ""
    },
    {
      text: "Couple Combo",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020005_17082018144820.jpg",
      color: ""
    },
    {
      text: "Regular Combo",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020007_16082018153109.jpg",
      color: ""
    },
    { text: "two", cols: 1.8, rows: 7, poster: "", color: "white" },
    //{text: '', cols: 1, rows: 7,poster:'', color: ''},
    {
      text: "Nachos with Salsa",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020006_06082018135441.jpg",
      color: ""
    },
    {
      text: "Veg Burger",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020016_17082018120212.jpg",
      color: ""
    },
    {
      text: "Sandwich",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020446_20082018182121.jpg",
      color: ""
    }
    // {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];
  noSeats: any;
  user: any;
  emailId: any;
  paymentStatus: BlockSeat;
  price: any;
  status: any;

  intervalId = 0;
  message = "";
  seconds = 60;
  minutes=2;

  constructor(private data: PaymentService) {}

  ngOnInit() {
    this.start();
    this.paymentStatus = new BlockSeat();
    this.user = localStorage.getItem("currentUser");
    console.log(localStorage.getItem("currentUser"));
    this.data.payMessage.subscribe(message => (this.paymentStatus = message));
    console.log("pay and seats", this.paymentStatus);
    this.noSeats = this.paymentStatus.seats.length;
    this.price = this.noSeats * 200;
  }

  onClickFail() {
    this.data.payMessage.subscribe(message => (this.paymentStatus = message));
    console.log("earlier payMessage", this.paymentStatus);
    this.paymentStatus.userName = localStorage.getItem("currentUser");
    this.paymentStatus.guestUserEmailId = this.emailId;
    //this.paymentStatus.showId=2;
    this.paymentStatus.status = "open";
    console.log("payment staus", this.paymentStatus);
    this.data.sendStatus(this.paymentStatus).subscribe(res => {
      console.log("staus posted");
    });
    (window as any).disconnect();
  }

  onClickSuccess() {
    this.data.payMessage.subscribe(message => (this.paymentStatus = message));
    console.log("earlier payMessage", this.paymentStatus);
    this.paymentStatus.userName = localStorage.getItem("currentUser");
    this.paymentStatus.guestUserEmailId = this.emailId;
    // this.paymentStatus.showId=2;
    this.paymentStatus.status = "booked";
    console.log("payment status", this.paymentStatus);
    this.data.sendStatus(this.paymentStatus).subscribe(status => {
      console.log("status", status);
    });
    (window as any).disconnect();
  }

  clearTimer() {
    clearInterval(this.intervalId);
  }
  ngOnDestroy() {
    this.clearTimer();
  }

  start() {
    this.countDown();
  }
  stop() {
    this.clearTimer();
  }

  private countDown() {
    this.clearTimer();
    this.intervalId = window.setInterval(() => {
      this.seconds -= 1;
      if (this.minutes < 0) {
        this.message = "Time Lapsed!";
        console.log(this.message);
        this.stop();
      }
      else if(this.seconds < 10) {
        this.message = `0${this.minutes}:0${this.seconds}`;
      
       if(this.seconds == 0) {
        this.seconds = 60;
        this.minutes -= 1;
      }
    }
      else {
        this.message = `0${this.minutes}:${this.seconds}`;
        console.log("Time Left: " + this.message);
      }
    }, 1000);
  }
}
