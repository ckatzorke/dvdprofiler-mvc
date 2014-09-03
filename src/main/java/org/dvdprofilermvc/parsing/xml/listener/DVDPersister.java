package org.dvdprofilermvc.parsing.xml.listener;

import org.dvdprofilermvc.parsing.xml.DVDEvent;
import org.dvdprofilermvc.parsing.xml.DVDEventListener;
import org.dvdprofilermvc.repository.api.DvdProfilerRepository;

public class DVDPersister implements DVDEventListener {

	private DvdProfilerRepository dvdProfilerRepository;

	public void setDvdProfilerRepository(DvdProfilerRepository dvdProfilerRepository) {
		this.dvdProfilerRepository = dvdProfilerRepository;
	}

	@Override
	public void onEvent(DVDEvent event) {
		dvdProfilerRepository.writeDvd(event.getDvd());
	}
}
