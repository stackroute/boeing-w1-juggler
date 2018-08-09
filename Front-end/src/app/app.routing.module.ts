import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomePageComponent } from "./home-page/home-page.component";
import { RegistrationFormComponent } from "./registration-form/registration-form.component";

const routes: Routes = [
 {
   path: "userRegistration",
   component: RegistrationFormComponent
 },
 // {
 //   path: "",
 //   component: RegistrationFormComponent
 // }
];

@NgModule({
 imports: [RouterModule.forRoot(routes)],
 exports: [RouterModule]
})
export class AppRoutingModule {}
export const routingComponents = [RegistrationFormComponent];