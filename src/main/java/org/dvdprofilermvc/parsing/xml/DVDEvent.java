package org.dvdprofilermvc.parsing.xml;

import org.dvdprofilermvc.model.DVD;

public class DVDEvent {
	private final DVD dvd;

	public DVDEvent(DVD dvd) {
		super();
		this.dvd = dvd;
	}

	public DVD getDvd() {
		return dvd;
	}
}
