import { Component, OnInit } from '@angular/core';
import { SearchDataService } from "../search-data.service";
import { RegistrationService } from "../registration.service";
import { Router } from "@angular/router";
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  yourData:any;
  movie:any;
  movieList:any[]
  constructor(private data: SearchDataService,
    private router: Router,private userData: RegistrationService) { }

  ngOnInit() {
    this.movieList=[];
    console.log(localStorage.getItem('currentUser'));
    this.userData.getUser(localStorage.getItem('currentUser')).subscribe(data=>
      {this.yourData=data
      console.log("your data",data);
      for (var i=0;i<(this.yourData.movieEvent).length;i++)
      {
        this.data.getMovieByCitynIduser(this.yourData.movieEvent[i].movieId,this.yourData.movieEvent[i].city).subscribe(data=> 
            {this.movie=data;
             console.log("movie data",data);
             this.movieList.push(this.movie);
            }
           )
      }
      console.log("movie List",this.movieList);}
    );
    
    // this.data.getMovieByCitynId(localStorage.getItem('userName')).subscribe(data=>
    //   {this.yourData=data
    //   console.log("your data",data)}
    // );
    
    
  }


}
