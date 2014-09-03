package org.dvdprofilermvc.repository.api;

import java.util.List;

import org.dvdprofilermvc.model.DVD;

public interface DvdProfilerRepository {

	public UpdateResult update(List<DVD> dvds);

	public String writeDvd(DVD dvd);

	public DVD readDvd(String id);

	public int getCount();

	public List<DVD> getAll();
}
