package com.stackroute.eplay.ticketengine.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArenaLayout {

	private List<Row> rows;
	
	@Getter
	@Setter
	@ToString
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Row{
		
		private int rowNo;
		private List<Seat> seats;
		
		@Getter
		@Setter
		@ToString
		@NoArgsConstructor
		@AllArgsConstructor
		public static class Seat{
			private int seatNo;
			private String status;
		}
	}
}
