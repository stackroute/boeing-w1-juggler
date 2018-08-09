package com.stackroute.eplay.userregistration.domain;

import java.io.File;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Model class for the Theatre
 */

@Document
public class Theatre {

	@Id
	private String theatreId;
	private String theatreName;
	private String theatreLocation;
	private int capacity;
	private File arenaFile;
	private String userName;

	public Theatre() {
	}

	public Theatre(String theatreId, String theatreName, String theatreLocation, int capacity, File arenaFile,
			String userName) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.capacity = capacity;
		this.arenaFile = arenaFile;
		this.userName = userName;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreLocation() {
		return theatreLocation;
	}

	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public File getArenaFile() {
		return arenaFile;
	}

	public void setArenaFile(File arenaFile) {
		this.arenaFile = arenaFile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreLocation="
				+ theatreLocation + ", capacity=" + capacity + ", arenaFile=" + arenaFile + ", userName=" + userName + "]";
	}

}