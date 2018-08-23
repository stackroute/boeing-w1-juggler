import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { RegistrationFormComponent } from "./registration-form/registration-form.component";
import { EventTypeComponent } from "./event-type/event-type.component";
import { OtherTicketedEventComponent } from "./other-ticketed-event/other-ticketed-event.component";
import { MovieEventComponent } from "./movie-event/movie-event.component";
import { HomePageComponent } from "./home-page/home-page.component";
import { RsvpEventComponent } from "./rsvp-event/rsvp-event.component";
import { RsvpInvitationComponent } from "./rsvp-invitation/rsvp-invitation.component";
import { LandingPageComponent } from "./landing-page/landing-page.component";
import { UserLoginComponent } from "./user-login/user-login.component"
import { AuthGuard } from "./guards/auth.guard"
import { TheatreComponent } from "./theatre/theatre.component";
import { RsvpEventpageComponent } from "./rsvp-eventpage/rsvp-eventpage.component";
import { SearchResultsComponent } from "./search-results/search-results.component";
import { MovieInfoComponent } from "./movie-info/movie-info.component";

const routes: Routes = [
  {
    path: "",
    component: LandingPageComponent
  },
  {
    path : "changeCity",
    component : LandingPageComponent
  },
  {
    path :"home",
    component :HomePageComponent
  },
  {
    path :"search",
    component :SearchResultsComponent
  },
  {
    path: "userRegistration",
    component: RegistrationFormComponent
  },
  {
    path: "userLogin",
    component: UserLoginComponent
  },
  {
    path: "createEvent",
    component: EventTypeComponent, canActivate:[AuthGuard]
  },
  {
    path: "createRSVPEvent",
    component: RsvpEventComponent
  },
  {
    path: "rsvpInvitation",
    component: RsvpInvitationComponent
  },
  {
    path: "movieinfo",
    component: MovieInfoComponent
  },
  {
    path: "createOtherTicketedEvent",
    component: OtherTicketedEventComponent
  },
  {
    path: "createMovieEvent",
    component: MovieEventComponent
  },
  {
    path: "theatre",
    component: TheatreComponent
  },
  {

    path:'rsvpEvent/:id',
    component:RsvpEventpageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
export const routingComponents = [
  RegistrationFormComponent,
  EventTypeComponent,
  OtherTicketedEventComponent,
  MovieEventComponent,
  RsvpEventComponent,
  SearchResultsComponent,
  UserLoginComponent,
  TheatreComponent
];
