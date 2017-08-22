package org.batch.domain;

public class Person {

	private int personid;
	private String lastName;
	private String firstName;

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Person(int personid, String lastName, String firstName) {
		super();
		this.personid = personid;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public Person() {
		super();
	}

}
