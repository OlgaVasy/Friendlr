package com.example.friendlr.mapper;

import org.mapstruct.Mapper;

import com.example.friendlr.dto.PersonDto;
import com.example.friendlr.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	Person fromDto(PersonDto personDto);
	PersonDto toDto(Person person);	

}