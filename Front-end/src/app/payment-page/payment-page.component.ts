import { Component, OnInit } from "@angular/core";
import { BlockSeat } from "../models/SeatBlock";
import { PaymentService } from "../payment.service";
import { Observable } from "rxjs";
import { AlertsService } from 'angular-alert-module';
import * as $ from "jquery";

export interface Tile {
  poster: string;
  cols: number;
  rows: number;
  text: string;
  color: string;
  price: number;
  count: number;
  overflow:string;
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
      color: "wheat",
      price: 280,
      count: 0,
      overflow:""
    },
    {
      text: "Couple Combo",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020005_17082018144820.jpg",
      color: "wheat",
      price: 570,
      count: 0,
      overflow:""
    },
    {
      text: "Regular Combo",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020007_16082018153109.jpg",
      color: "wheat",
      price: 380,
      count: 0,
      overflow:""
    },
    { text: "two", cols: 1.8, rows: 7, poster: "", color: "wheat", price: 0, count: 0,overflow:"scroll" },
    //{text: '', cols: 1, rows: 7,poster:'', color: ''},
    {
      text: "Nachos with Salsa",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020006_06082018135441.jpg",
      color: "wheat",
      price: 250,
      count: 0,
      overflow:""
    },
    {
      text: "Veg Burger",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020016_17082018120212.jpg",
      color: "wheat",
      price: 150,
      count: 0,
      overflow:""
    },
    {
      text: "Sandwich",
      cols: 1,
      rows: 3,
      poster:
        "https://in.bmscdn.com/bmsin/v2/Web-v2/d-combo/1020446_20082018182121.jpg",
      color: "wheat",
      price: 150,
      count: 0,
      overflow:""
    }
    // {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];
  noSeats = 0;
  user: any;
  emailId: any;
  paymentStatus: BlockSeat;
  price = 0;
  totalAmount = 0;
  status: any;
  items = [];
  tax = 0;
  tile1 : Tile;
  //itemCount=1;
  flag:any;
  clicked:any;
  intervalId = 0;
  timer = "";
  seconds = 50;
  minutes = 0;
  handler;

  constructor(private data: PaymentService, private alerts: AlertsService) {}

  
  ngOnInit() {
    this.start();
    this.paymentStatus = new BlockSeat();
    this.user = localStorage.getItem("currentUser");
    console.log(localStorage.getItem("currentUser"));
    this.data.payMessage.subscribe(message => (this.paymentStatus = message));
    console.log("pay and seats", this.paymentStatus);
    this.noSeats = this.paymentStatus.seats.length;
    this.price = this.noSeats * 200;
    this.tax = ( this.noSeats * 200 * .18);
    this.totalAmount =( this.noSeats * 200 )+ this.tax; 
  }

  openCheckout() {
    this.handler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_K2C3smobEhEs1C5VDNs9iXn6',
      locale: 'auto',
      currency: 'INR',
      token: function (token: any) {
        // You can access the token ID with `token.id`.
        // Get the token ID to your server-side code for use.
        //this.data.sendToken("token").subscribe(res => console.log(res));
        // console.log(token)
        // $.ajax({
        //     url: "http://localhost:8080/api/v1/charge",
        //     type: 'post',
        //     data: token.id,
        //     success: function(data) {
        //       if (data == 'success') {
        //           console.log("Card successfully charged!");
        //       }
        //       else {
        //           console.log("Success Error!");
        //       }
  
        //     },
        //     error: function(data) {
        //       console.log("Ajax Error!");
        //       console.log(data);
        //     }
        //   }); // end ajax call
      }
    });
    
    this.handler.open({
      name: 'Payment Gateway',
      amount: 2000
    });
    
  }

  onClickFail() {
    this.flag= true; 
    this.data.payMessage.subscribe(message => (this.paymentStatus = message));
    console.log("earlier payMessage", this.paymentStatus);
    this.paymentStatus.userName = localStorage.getItem("currentUser");
    this.paymentStatus.guestUserEmailId = this.emailId;
    this.paymentStatus.status = "open";
    console.log("payment staus", this.paymentStatus);
    this.data.sendStatus(this.paymentStatus);
    (window as any).disconnect();
    this.alerts.setMessage('Payment failed, please try again.','error');
  }

  onClickSuccess() {
    this.clicked=true;
    this.flag= true;
    this.data.payMessage.subscribe(message => (this.paymentStatus = message));
    console.log("earlier payMessage", this.paymentStatus);
    this.paymentStatus.userName = localStorage.getItem("currentUser");
    this.paymentStatus.guestUserEmailId = this.emailId;
    // this.paymentStatus.showId=2;
    this.paymentStatus.status = "booked";
    console.log("payment status", this.paymentStatus);
    this.data.sendStatus(this.paymentStatus);
    (window as any).disconnect();
    this.alerts.setMessage('Seat No: '+JSON.stringify(this.paymentStatus.seats)+' booked successfully','success');
  }

  itemsAdded(it) {
    //this.items=items;
    if (this.items.length < 4) {
      this.items.push(it);
      console.log(JSON.stringify(this.items));
    }
    if (this.items.length > 4) {
      console.log("Max 4 items allowed");
    }
  }

  minusItem(i,itemCount) {
    
    if(this.items[i].count < 1) {
      this.items.splice(this.items.indexOf(this.items),1);
    }
    // items.count -= 1;
    // console.log(items.count);
    this.items[i].count= itemCount - 1;
  }

  addItem(i,itemCount) {
    console.log("Index" + itemCount);
    this.items[i].count = itemCount + 1;
    console.log(this.items[i]);
    console.log(this.items);
  }

  //  addItem(tile) {
  //    tile.count +=1;
  //   this.items= tile;
  //   console.log(" Tile count inside Additem" +tile.count);
  // }
  deleteItem(items) {
    this.items.splice(this.items.indexOf(items),1);
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
        this.timer = "Time Lapsed!";
        if(this.handler!=null)
          this.handler.close();

        this.flag= true;
        console.log(this.timer);
        this.stop();
      } else if (this.seconds < 10) {
        this.timer = `0${this.minutes}:0${this.seconds}`;

        if (this.seconds == 0) {
          this.seconds = 60;
          this.minutes -= 1;
        }
      } else {
        this.timer = `0${this.minutes}:${this.seconds}`;
        //console.log("Time Left: " + this.timer);
      }
    }, 1000);
  }
}
