package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.data.vo.v1.PersonVO;
import com.example.demo.data.vo.v2.PersonVOV2;
import com.example.demo.mapper.custom.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.service.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonServices service;
	
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(@PathVariable(value="id")Long id) {
		return service.findById(id);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll(){
		return service.findAll();
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create(@RequestBody PersonVO personvo) {
		return service.create(personvo);
	}
	
	@PostMapping(value="/v2",consumes=MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV2 createV2(@RequestBody PersonVOV2 personvo) {
		return service.createV2(personvo);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(@RequestBody PersonVO personvo) {
		return service.update(personvo);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?>delete(@PathVariable(value="id")Long id) {
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	}


}
