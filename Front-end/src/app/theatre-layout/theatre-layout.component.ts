import { Component, OnInit } from "@angular/core";
import * as $ from "jquery";
var jquery: any;

@Component({
  selector: "app-theatre-layout",
  templateUrl: "./theatre-layout.component.html",
  styleUrls: ["./theatre-layout.component.css"]
})
export class TheatreLayoutComponent implements OnInit {
  seatingValue = [];
  totalRow: any[];
  totalCol: any[];
  public id: any[] ;
  public Id : any[];   // Final array to be sent to booking api
  arr = [];
  constructor() {}
  ngOnInit() {
    //  $(function() {
    //   $("#btnSeating").on("click", createseating);
    //  });
    this.id=[];
    this.Id=[];
    this.createseating();
    this.totalRow = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    this.totalCol = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  }

  // to create seating layout
  createseating() {
    for (var i = 0; i < 10; i++) {
      for (var j = 0; j < 10; j++) {
        let seatingStyle = "<div class='seat available'></div>";
        this.seatingValue.push(seatingStyle);
        // if (j == 5) {
        //   // only for understanding
        //   //console.log("hi");
        //   seatingStyle = "<div class='clearfix'></div>";
        //   this.seatingValue.push(seatingStyle);
        //   //console.log(seatingStyle);
        // }
      }
    }

    //Hovering and Clicking effects on seats
    $(function() {
      $(".seat").on("click", function() {
        if ($(this).hasClass("selected")) {
          $(this).removeClass("selected");
          console.log("Seat Id: " + this.id + " is removed");
        } else {
          $(this).addClass("selected");
        }
      });

      $(".seat").mouseenter(function() {
        $(this).addClass("hovering");

        $(".seat").mouseleave(function() {
          $(this).removeClass("hovering");
        });
      });
    });
  }

  //  For adding a seat Id in an Array on every click
  onclick(x,y){
    (this.id).push((x*10)+y);
    console.log(this.id);
  }

  // To make an array of filtered seats which are to be sent to booking API
  bookticket(){
    let map = new Map<String, number>(); 
    for(var i=0;i<(this.id).length;i++)
    { 
        if(map.get(this.id[i]))
        {map.set(this.id[i],map.get(this.id[i])+1);}
        else
        {
          map.set(this.id[i],1);
        }
    }
    console.log(map);
    map.forEach((value:number, key:String)=>{
      if(value%2!=0){
        this.Id.push(key);
      }
    });
    console.log(this.Id);
  }
}
