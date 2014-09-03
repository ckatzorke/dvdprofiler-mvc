package org.dvdprofilermvc.repository.api;

public class UpdateResult {
	private int inserts;
	private int deletions;
	private int updates;

	public int getInserts() {
		return inserts;
	}

	public void incInserts() {
		inserts++;
	}

	public void setInserts(int inserts) {
		this.inserts = inserts;
	}

	public int getDeletions() {
		return deletions;
	}

	public void incDelections() {
		deletions++;
	}

	public void setDeletions(int deletions) {
		this.deletions = deletions;
	}

	public int getUpdates() {
		return updates;
	}

	public void incUpdates() {
		updates++;
	}

	public void setUpdates(int updates) {
		this.updates = updates;
	}

}
