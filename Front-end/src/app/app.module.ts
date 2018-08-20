import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { AppComponent } from "./app.component";
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MaterialModule } from "./material";
import { MoviesComponent } from "./movies/movies.component";
import { HomePageComponent } from "./home-page/home-page.component";
import { MovieCardComponent } from "./movies/movie-card/movie-card.component";
import { AppRoutingModule } from "./app.routing.module";
import { RegistrationFormComponent } from "./registration-form/registration-form.component";
import { EventTypeComponent } from "./event-type/event-type.component";
import { MatCardModule } from "@angular/material/card";
import { OtherTicketedEventComponent } from "./other-ticketed-event/other-ticketed-event.component";
import { MovieEventComponent } from "./movie-event/movie-event.component";
import { MatSelectModule } from "@angular/material/select";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { NativeDateModule } from "@angular/material";
import { MatNativeDateModule } from "@angular/material";
import { ReactiveFormsModule } from "@angular/forms";
import { RsvpInvitationComponent } from './rsvp-invitation/rsvp-invitation.component';
import { RsvpEventComponent } from './rsvp-event/rsvp-event.component';
import { FlexLayoutModule } from "@angular/flex-layout";
import { LandingPageComponent } from './landing-page/landing-page.component';
import { EventCardComponent } from './home-page/event-card/event-card.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { TheatreComponent } from './theatre/theatre.component';
import { RsvpEventpageComponent } from './rsvp-eventpage/rsvp-eventpage.component';
import {MatRadioModule} from '@angular/material/radio';

@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    HomePageComponent,
    MovieCardComponent,
    RegistrationFormComponent,
    EventTypeComponent,
    OtherTicketedEventComponent,
    RsvpEventComponent,
    MovieEventComponent,
    RsvpInvitationComponent,
    LandingPageComponent,
    EventCardComponent,
    NavBarComponent,
    TheatreComponent,
    RsvpEventpageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    AppRoutingModule,
    MatCardModule,
    MatRadioModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    FlexLayoutModule
  ],
  providers: [MatNativeDateModule],
  bootstrap: [AppComponent]
})
export class AppModule {}
