import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomePageComponent } from "./home-page/home-page.component";
import { RegistrationFormComponent } from "./registration-form/registration-form.component";
import { EventTypeComponent } from "./event-type/event-type.component";
import { OtherTicketedEventComponent } from "./other-ticketed-event/other-ticketed-event.component";
import { MovieEventComponent } from "./movie-event/movie-event.component";
const routes: Routes = [
 {
   path: "userRegistration",
   component: RegistrationFormComponent
 },
 {
   path : "createEvent",
   component:EventTypeComponent
 },
 {
   path : "createOtherTicketedEvent",
   component :OtherTicketedEventComponent 
 },
 {
   path : "createMovieEvent",
   component : MovieEventComponent
 }
];

@NgModule({
 imports: [RouterModule.forRoot(routes)],
 exports: [RouterModule]
})
export class AppRoutingModule {}
export const routingComponents = [RegistrationFormComponent,EventTypeComponent,OtherTicketedEventComponent,MovieEventComponent];