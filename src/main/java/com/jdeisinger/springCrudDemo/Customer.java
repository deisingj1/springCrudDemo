package com.jdeisinger.springCrudDemo;

public class Customer {
	private long id;
	private String firstName, lastName;
	
	public Customer(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, firstName='%s', lastName='%s']",
				id, firstName,lastName);
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return firstName + " " + lastName;
	}
	//getters and setters left out
}
