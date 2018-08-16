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
import { RsvpEventpageComponent } from "./rsvp-eventpage/rsvp-eventpage.component";
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
    path: "userRegistration",
    component: RegistrationFormComponent
  },
  {
    path: "createEvent",
    component: EventTypeComponent
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
    path: "createOtherTicketedEvent",
    component: OtherTicketedEventComponent
  },
  {
    path: "createMovieEvent",
    component: MovieEventComponent
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
  RsvpEventComponent
];
