import { Injectable } from '@angular/core';
import{InputEmailsDetails} from "./InputEmailsDetails";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmailService {

   url= "http://172.23.238.188:9000/api/v1/email/sendEmail";

   // inputEmailsDetails:InputEmailsDetails;
  constructor(private http: HttpClient) {}
    sendInvitations(inputEmailsDetails:InputEmailsDetails):Observable<string>
  {
    return this.http.post<string>(this.url,inputEmailsDetails);
  }
}
