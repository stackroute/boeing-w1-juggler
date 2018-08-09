package com.stackroute.eplay.upstreamservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class invitation {

	@Id
	private String invitationId;
	private String EventId;
	private String inviteeUserName;
	private String inviteeName;
	private String inviteeEmail;
	private String inviteePhoneNo;
	private boolean status;
}
