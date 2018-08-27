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
 this.data.changeMessage("Delhi");
 localStorage.setItem('city', 'Delhi');
}
onclick2(){console.log("Location : Mumbai");
localStorage.setItem('city',"Patna");
this.data.changeMessage("Mumbai");
localStorage.setItem('city', 'Mumbai');

}
onclick3(){console.log("Location : Bangalore");
localStorage.setItem('city',"Patna");
this.data.changeMessage("Bangalore");
localStorage.setItem('city', 'Bangalore');

}
onclick4(){console.log("Location : Hyderabad");
localStorage.setItem('city',"Hyderabad");
this.data.changeMessage("Hyderabad");
localStorage.setItem('city', 'Hyderabad');

}

}