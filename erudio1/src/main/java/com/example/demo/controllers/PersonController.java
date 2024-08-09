package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Person;
import com.example.demo.service.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonServices service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value="id")String id) throws Exception{
		return service.findById(id);
	}
	

}
