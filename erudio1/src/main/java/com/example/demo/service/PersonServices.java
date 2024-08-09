package com.example.demo.service;

import java.util.concurrent.atomic.*;
import java.util.logging.Logger;
import com.example.demo.model.Person;

import org.springframework.stereotype.Service;

//import com.example.demo.model.Person;

@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger=Logger.getLogger(PersonServices.class.getName());
	
	
	public Person findById(String id) {
		logger.info("finding one person");
		Person person=new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Marcos");
		person.setLastName("Ribeiro");
		person.setAddress("Parnamirim - RN - Brasil");
		person.setGender("male");
		return person;
	}

}
