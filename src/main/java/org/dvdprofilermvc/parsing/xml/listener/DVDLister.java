package org.dvdprofilermvc.parsing.xml.listener;

import java.util.ArrayList;
import java.util.List;

import org.dvdprofilermvc.model.DVD;
import org.dvdprofilermvc.parsing.xml.DVDEvent;
import org.dvdprofilermvc.parsing.xml.DVDEventListener;

public class DVDLister implements DVDEventListener {

	private final List<DVD> dvds = new ArrayList<DVD>();

	public List<DVD> getDvds() {
		return dvds;
	}

	@Override
	public void onEvent(DVDEvent event) {
		dvds.add(event.getDvd());

	}

}
