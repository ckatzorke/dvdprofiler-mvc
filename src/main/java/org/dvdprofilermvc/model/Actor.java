package org.dvdprofilermvc.model;

public class Actor extends Person {
	String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Actor [role=" + role + ", getFirstName()=" + getFirstName() + ", getMiddleName()=" + getMiddleName()
				+ ", getLastName()=" + getLastName() + ", getBirthYear()=" + getBirthYear() + "]";
	}

}
