package com.example.friendlr.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.friendlr.dto.PersonDto;
import com.example.friendlr.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {

	private PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping
	public List<PersonDto> getPersonDto() {
		return personService.getAll();
	}

	@GetMapping("{id}")
	public PersonDto getPersonById(@PathVariable Integer id,HttpServletResponse response) {
		if(personService.findById(id) != null)
			return personService.findById(id);
		else{
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
	}	
	}
	@PostMapping
	public void buildAPerson(@RequestBody PersonDto buildIt, HttpServletResponse response) {	

		if(personService.create(buildIt))
			response.setStatus(HttpServletResponse.SC_CREATED);
		else
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}		
}