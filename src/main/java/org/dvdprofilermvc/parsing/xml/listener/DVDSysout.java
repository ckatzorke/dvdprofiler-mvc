package org.dvdprofilermvc.parsing.xml.listener;

import org.dvdprofilermvc.parsing.xml.DVDEvent;
import org.dvdprofilermvc.parsing.xml.DVDEventListener;

public class DVDSysout implements DVDEventListener {

	@Override
	public void onEvent(DVDEvent event) {
		System.out.println(event.getDvd());
	}

}
