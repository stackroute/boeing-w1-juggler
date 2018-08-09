import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AppComponent } from "./app.component";
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MaterialModule } from "./material";
import { MoviesComponent } from "./movies/movies.component";
import { HomePageComponent } from "./home-page/home-page.component";
import { MovieCardComponent } from "./movies/movie-card/movie-card.component";
import { AppRoutingModule } from "./app.routing.module";
import { RegistrationFormComponent } from './registration-form/registration-form.component';
// import { EventTypeComponent } from './event-type/event-type.component';
import {MatCardModule} from '@angular/material/card';
import { RsvpEventComponent } from './rsvp-event/rsvp-event.component';
// import { RegistrationFormComponent } from "./registration-form/registration-form.component";
import { MovieCreationComponent } from "./movie-creation/movie-creation.component";
import { MatSelectModule } from "@angular/material/select";
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material';
import { RsvpInvitationComponent } from './rsvp-invitation/rsvp-invitation.component';

@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    HomePageComponent,
    MovieCardComponent,
    RegistrationFormComponent,
    // EventTypeComponent,
    RsvpEventComponent,

    MovieCreationComponent,

    RsvpInvitationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    AppRoutingModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [
    MatNativeDateModule,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
