package com.example.friendlr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.friendlr.dto.PersonDto;
import com.example.friendlr.entity.Person;
import com.example.friendlr.mapper.PersonMapper;

@Service
public class PersonService {

	private Long idGenerator = (long) 0;
	private List<Person> personList = new ArrayList<Person>();	
	private PersonMapper personMapper;	

	public PersonService(PersonMapper personMapper) {		
		this.personMapper = personMapper;
	}

	public List<PersonDto> getAll() {
		return personList.stream().map(
				personMapper::toDto
				).collect(Collectors.toList());
	}

	public PersonDto findById(Integer id) {
		return toPersonDto(personList.get(id));
	}
	
	public Person findPersonById(Integer id) {
		return toPerson(getAll().get(id));
	}

	public boolean create(PersonDto buildIt) {		

		Person person1 = personMapper.fromDto(buildIt);	
		person1.setId(idGenerator++);
		personList.add(person1);
		return true;
	}
	public List<Long> friendsToIds(List<Person>friends){
		List<Long>ids = new ArrayList<Long>();
		for (int i=0;i<friends.size();i++)
			ids.add(friends.get(i).getId());
		return ids;		
	}
	
	public List<Person> idsToFreinds(List<Long>ids){
		List<Person>friends = new ArrayList<Person>();
		for (int i=0;i<ids.size();i++)
			friends.add(findPersonById(i));
		return friends;		
	}

	public Person toPerson(PersonDto transform) {
		return new Person(transform.getId(), transform.getFirstName(), transform.getLastName(), idsToFreinds(transform.getIds()));
	}	

	public PersonDto toPersonDto(Person transform) {
		return new PersonDto(transform.getId(), transform.getFirstName(), transform.getLastName(),friendsToIds(transform.getFriends()));
	}

	public void Friend(Integer personId, Integer friendId) {	
		findPersonById(personId).getFriends().add(findPersonById(friendId));	
	}
}
