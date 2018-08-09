package com.stackroute.eplay.upstreamservice.service;

import com.stackroute.eplay.upstreamservice.domain.Movie;
import com.stackroute.eplay.upstreamservice.domain.MovieEvent;
import com.stackroute.eplay.upstreamservice.domain.TicketedEvent;
import com.stackroute.eplay.upstreamservice.domain.RSVPEvent;
import com.stackroute.eplay.upstreamservice.domain.Show;
import com.stackroute.eplay.upstreamservice.domain.Theatre;

public interface UpStreamService {

	public void saveMovieEvent(MovieEvent event);
	public void saveTicketedEvent(TicketedEvent event);
	public void saveRSVPEvent(RSVPEvent event);
	public void saveMovie(Movie event);
	public void saveTheatre(Theatre event);
	public void saveShow(Show show);
}
