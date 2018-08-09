import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material';
import { MoviesComponent } from './movies/movies.component';
import { HomePageComponent } from './home-page/home-page.component';
import { MovieCardComponent } from './movies/movie-card/movie-card.component';
import { AppRoutingModule } from "./app.routing.module";
import { RegistrationFormComponent } from './registration-form/registration-form.component';


@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    HomePageComponent,
    MovieCardComponent,
    RegistrationFormComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    AppRoutingModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }