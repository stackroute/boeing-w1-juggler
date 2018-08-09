package com.stackroute.eplay.userregistration.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Model class for the Invitation
 */

@Document
public class Invitation {

    @Id
    private String invitationId;
    private String EventId;
    private String inviteeUserName;
    private String inviteeName;
    private String inviteeEmail;
    private String inviteePhoneNo;
    private boolean status;
    
    public Invitation() { }

	public Invitation(String invitationId, String eventId, String inviteeUserName, String inviteeName,
			String inviteeEmail, String inviteePhoneNo, boolean status) {
		super();
		this.invitationId = invitationId;
		EventId = eventId;
		this.inviteeUserName = inviteeUserName;
		this.inviteeName = inviteeName;
		this.inviteeEmail = inviteeEmail;
		this.inviteePhoneNo = inviteePhoneNo;
		this.status = status;
	}

	public String getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}

	public String getEventId() {
		return EventId;
	}

	public void setEventId(String eventId) {
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
		return "Invitation [invitationId=" + invitationId + ", EventId=" + EventId + ", inviteeUserName="
				+ inviteeUserName + ", inviteeName=" + inviteeName + ", inviteeEmail=" + inviteeEmail
				+ ", inviteePhoneNo=" + inviteePhoneNo + ", status=" + status + "]";
	}
    
    
}