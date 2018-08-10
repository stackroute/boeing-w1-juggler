import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RsvpInvitation } from './RsvpInvitation';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RsvpInvitationService {

  private _url: string="http://localhost:8092/api/v1/invitation";
  private _url1: string="http://localhost:8092/api/v1/invitations";
  private _url2: string="http://localhost:8092/api/v1/invitation";

  constructor(private http:HttpClient) { }

  saveRsvpInvitation(rsvpInvitation:RsvpInvitation)
  {
    return this.http.post<RsvpInvitation>(this._url,rsvpInvitation);
  }

  getAllRsvpInvitations(): Observable<RsvpInvitation[]>
  {
    return this.http.get<RsvpInvitation[]>(this._url1);
  }

  deleteRsvpInvitations(invitationId)
  {
    return this.http.delete(this._url2+invitationId);
  }
}
