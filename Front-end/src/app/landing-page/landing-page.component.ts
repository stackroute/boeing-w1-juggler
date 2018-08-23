import { Component, OnInit } from '@angular/core';
import { SearchDataService } from "../search-data.service";

@Component({
 selector: 'app-landing-page',
 templateUrl: './landing-page.component.html',
 styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

 message:string;

 constructor(private data: SearchDataService) { }
 ngOnInit() {
 }
 onclick1(){console.log("Location : Delhi");
 localStorage.setItem('city',"Patna");
 this.data.changeMessage("Patna");
}
onclick2(){console.log("Location : Mumbai");
localStorage.setItem('city',"Patna");
this.data.changeMessage("mumbai");
}
onclick3(){console.log("Location : Bangalore");
localStorage.setItem('city',"Patna");
this.data.changeMessage("banglore");
}
onclick4(){console.log("Location : Hyderabad");
localStorage.setItem('city',"Hyderabad");
this.data.changeMessage("hyderabad");
}

}