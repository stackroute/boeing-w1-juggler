import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http"; // to access the get method for accessing the file data
import { HttpErrorResponse } from "@angular/common/http"; // for printing error message
import * as $ from "jquery";
var jquery: any;

@Component({
  selector: "app-theatre-layout",
  templateUrl: "./theatre-layout.component.html",
  styleUrls: ["./theatre-layout.component.css"]
})
export class TheatreLayoutComponent implements OnInit {
  seatingValue = [];
  totalRow = [];
  totalCol = [];
  jsonRow: any[];
  passage = [];
  rowPassage=[];
  public id: any[];
  public Id: any[]; // Final array to be sent to booking api

  constructor(private httpService : HttpClient) {}
  ngOnInit() {
    
    this.id=[];
    this.Id=[];
    
    this.httpService.get("./assets/layout.json").subscribe(
      data => {
        this.jsonRow = data as string[]; // FILL THE ARRAY WITH DATA.
        // console.log("jsonRow[0].value :", this.jsonRow[0].totalRow);
        // console.log("jsonRow[1].value :", this.jsonRow[1].totalCol);
        this.totalRow.length = this.jsonRow[0].totalRow; 
        this.totalCol.length = this.jsonRow[1].totalCol;
        this.totalRow.values= this.jsonRow[0].Values;
        this.totalCol.values=this.jsonRow[1].Values;
        
        // to get the passage columns
        this.passage= this.jsonRow[2].passageCol;
        this.rowPassage= this.jsonRow[3].passageRow;
        console.log(this.passage);
        
        this.createseating();
      },
      (err: HttpErrorResponse) => {
        console.log(err.message);
      }
    );
  }

  // to create seating layout
  createseating() {
    for (var i = 0; i < 10; i++) {
      for (var j = 0; j < 10; j++) {
        let seatingStyle = "<div class='seat available'></div>";
        this.seatingValue.push(seatingStyle);
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
