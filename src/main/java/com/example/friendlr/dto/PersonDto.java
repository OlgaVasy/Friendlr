package com.example.friendlr.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonDto {

	private Long id;
	private String firstName;
	private String lastName;
	private List<Long>ids = new ArrayList<Long>();	

	public PersonDto() {	
	}	

	public PersonDto(Long id, String firstName, String lastName, List<Long>ids) {
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setIds(ids);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id2) {
		this.id = id2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}	



	

}