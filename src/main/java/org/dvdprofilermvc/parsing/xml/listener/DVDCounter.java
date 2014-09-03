package org.dvdprofilermvc.parsing.xml.listener;

import org.dvdprofilermvc.parsing.xml.DVDEvent;
import org.dvdprofilermvc.parsing.xml.DVDEventListener;

public class DVDCounter implements DVDEventListener {

	int counter = 0;

	@Override
	public void onEvent(DVDEvent event) {
		counter++;
		System.out.println("#" + counter);
	}

	public int getCounter() {
		return counter;
	}

}
