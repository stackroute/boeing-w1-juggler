import { Component, OnInit } from '@angular/core';
import { SearchDataService } from "../search-data.service";

import { AuthenticationService } from '../authentication.service';
@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  omdbSearchTitle: string;

  constructor(
    private data: SearchDataService,
    private authenticationService:AuthenticationService
  ) { }

  ngOnInit() {
  }
  onSearch(){
    console.log(this.omdbSearchTitle);
    this.data.changeMessage(this.omdbSearchTitle);

  }
}
