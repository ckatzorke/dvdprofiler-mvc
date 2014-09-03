package org.dvdprofilermvc.repository.impl.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dvdprofilermvc.model.DVD;
import org.dvdprofilermvc.repository.api.DvdProfilerRepository;
import org.dvdprofilermvc.repository.api.UpdateResult;

public class InMemoryDvdProfilerRepository implements DvdProfilerRepository {

	private final Map<String, DVD> dvds = new HashMap<>();

	@Override
	public String writeDvd(DVD dvd) {
		dvds.put(dvd.getId(), dvd);
		return dvd.getId();
	}

	@Override
	public DVD readDvd(String id) {
		return dvds.get(id);
	}

	@Override
	public UpdateResult update(List<DVD> dvds) {
		final UpdateResult result = new UpdateResult();
		final Map<String, DVD> newCollection = new HashMap<>();
		dvds.forEach(dvd -> {
			if (dvds.contains(dvd.getId())) {
				result.incUpdates();
			} else {
				result.incInserts();
			}
			newCollection.put(dvd.getId(), dvd);
		});
		final int deletions = this.dvds.size() - newCollection.size() + result.getInserts();
		result.setDeletions(deletions);
		this.dvds.clear();
		this.dvds.putAll(newCollection);
		return result;
	}

	@Override
	public int getCount() {
		return dvds.size();
	}

	@Override
	public List<DVD> getAll() {
		final List<DVD> all = new ArrayList<>();
		all.addAll(dvds.values());
		return all;
	}

}
