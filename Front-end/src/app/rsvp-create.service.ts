import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { RsvpCreate } from "./RsvpCreate";
import { RsvpInvitation } from "./RsvpInvitation";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class RsvpCreateService {
  private _url: string = "http://172.23.238.218:8097/api/v1/event/rsvpEvent";
  private _url1: string = "http://172.23.238.218:8097/api/v1/event/rsvpEvents";
  private _url2: string = "http://172.23.238.218:8097/api/v1/event/rsvpEvent";
  private _url4: string = "http://172.23.238.218:8097/api/v1/event/invitation";
  private _url3: string =
    "http://172.23.238.220:8097/api/v1/event/upstream/rsvpEvent";

    private _url5: string = "http://172.23.238.218:8097/api/v1/invitation/";

  rsvpCreate: RsvpCreate;
  // rsvpInvitationModel: RsvpInvitation;
  constructor(private http: HttpClient) {}

  saveRsvpEvent(rsvpCreate: RsvpCreate): Observable<RsvpCreate> {
    return this.http.post<RsvpCreate>(this._url3, rsvpCreate);
  }

  getAllRsvpEvents(): Observable<RsvpCreate[]> {
    return this.http.get<RsvpCreate[]>(this._url1);
  }

  getRsvpEventById(id): Observable<RsvpCreate> {
    return this.http.get<RsvpCreate>(this._url2 + "/" + id);
  }

  deleteRsvp(id) {
    return this.http.delete(this._url2 + id);
  }

  updateRsvp(rsvpInvitationModel: RsvpInvitation, id): Observable<RsvpCreate> {
    console.log(rsvpInvitationModel);
    console.log(id);
    return this.http.put<RsvpCreate>(
      this._url4 + "/" + id,
      rsvpInvitationModel
    );
  }

  getInvitaionByInviteeEmail(inviteeEmail):Observable<RsvpInvitation>
  {
    return this.http.get<RsvpInvitation>(this._url5+inviteeEmail);
  }
}
