package com.stackroute.rsvp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class RsvpInvitation {
	
	@Id
    private String invitationId;    //unique 
    private int EventId;        //id from Event table
    private String inviteeUserName; //from user register table
    private String inviteeName;   //from user register table
    private String inviteeEmail;  //from user register table
    private String inviteePhoneNo;//from user register table
    private boolean status;
	public RsvpInvitation(String invitationId, int eventId, String inviteeUserName, String inviteeName, String inviteeEmail,
			String inviteePhoneNo, boolean status) {
		super();
		this.invitationId = invitationId;
		EventId = eventId;
		this.inviteeUserName = inviteeUserName;
		this.inviteeName = inviteeName;
		this.inviteeEmail = inviteeEmail;
		this.inviteePhoneNo = inviteePhoneNo;
		this.status = status;
	}
	public String getinvitationId() {
		return invitationId;
	}
	public void setinvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public int getEventId() {
		return EventId;
	}
	public void setEventId(int eventId) {
		EventId = eventId;
	}
	public String getInviteeUserName() {
		return inviteeUserName;
	}
	public void setInviteeUserName(String inviteeUserName) {
		this.inviteeUserName = inviteeUserName;
	}
	public String getInviteeName() {
		return inviteeName;
	}
	public void setInviteeName(String inviteeName) {
		this.inviteeName = inviteeName;
	}
	public String getInviteeEmail() {
		return inviteeEmail;
	}
	public void setInviteeEmail(String inviteeEmail) {
		this.inviteeEmail = inviteeEmail;
	}
	public String getInviteePhoneNo() {
		return inviteePhoneNo;
	}
	public void setInviteePhoneNo(String inviteePhoneNo) {
		this.inviteePhoneNo = inviteePhoneNo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RsvpInvitation [invitationId=" + invitationId + ", EventId=" + EventId + ", inviteeUserName="
				+ inviteeUserName + ", inviteeName=" + inviteeName + ", inviteeEmail=" + inviteeEmail
				+ ", inviteePhoneNo=" + inviteePhoneNo + ", status=" + status + "]";
	}
	
	

}
