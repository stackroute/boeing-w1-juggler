import { Component, OnInit } from '@angular/core';
import * as $ from "jquery";
var jquery: any;

@Component({
  selector: 'app-theatre-layout',
  templateUrl: './theatre-layout.component.html',
  styleUrls: ['./theatre-layout.component.css']
})
export class TheatreLayoutComponent implements OnInit {
  seatingValue = [];
  totalRow:any[];
  totalCol:any[];
  constructor() {}
  ngOnInit() {
    //  $(function() {
    //   $("#btnSeating").on("click", createseating);
    //  });
    this.createseating();
    this.totalRow=[0,1,2,3,4,5,6,7,8,9];
    this.totalCol=[0,1,2,3,4,5,6,7,8,9];
  }
  //Note:In js the outer loop runs first then the inner loop runs completely so it goes o.l. then i.l. i.l .i.l .i.l. i.l etc and repeat
  createseating() {
    for (var i = 0; i < 10; i++) {
      for (var j = 0; j < 10; j++) {
        let seatingStyle = "<div class='seat available'></div>";
        this.seatingValue.push(seatingStyle);
        if (j === 9) {
          //console.log("hi");
          seatingStyle = "<div class='clearfix'></div>";
          this.seatingValue.push(seatingStyle);
          //console.log(seatingValue + seatingStyle);
        }
      }
    }

    $(function() {
      $(".seat").on("click", function() {
        if ($(this).hasClass("selected")) {
          $(this).removeClass("selected");
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
}
