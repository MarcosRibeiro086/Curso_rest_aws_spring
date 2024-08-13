package com.example.demo.service;

import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.logging.Logger;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.model.Person;

@Service
public class PersonServices {
	private Logger logger=Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll(){
		
		logger.info("finding all people!");

		return repository.findAll();
	}
	
	public Person create (Person person) {
		logger.info("Creating one person!");
		return repository.save(person);
	}
	
	
	public Person update (Person person) {
		logger.info("Updating one person!");
		
		//recupera por id jogo na dentro da variável para modificar o objeto escolhido
		var entity=repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(person);
	}
	
	public void delete (Long id) {
		logger.info("Deleting one person");
		//recuperando a entidade a ser deletada
		var entity=repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
	
	public Person findById(Long id) {
		logger.info("finding one person");

		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	
}
