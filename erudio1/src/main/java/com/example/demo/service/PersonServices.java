package com.example.demo.service;

import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.logging.Logger;

import com.example.demo.data.vo.v1.PersonVO;
import com.example.demo.data.vo.v2.PersonVOV2;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.mapper.custom.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.model.PersonVO;

@Service
public class PersonServices {
	private Logger logger=Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll(){
		
		logger.info("finding all people!");

		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		logger.info("finding one Person");
		
		var entity =repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
		

		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	
	public PersonVO create (PersonVO person) {
		logger.info("Creating one PersonVO!");
		
		//converter para person para salvar no banco
		var entity = DozerMapper.parseObject(person,Person.class);
		//converte para VO para apresentar os dados;
		var vo=DozerMapper.parseObject( repository.save(entity),PersonVO.class);
		
		return vo;
	}
	//criando uma v2 para opção de campos, utilizando mapper customizado para o vov2
	public PersonVOV2 createV2 (PersonVOV2 person) {
		logger.info("Creating one PersonVO!");
		
		//converter para person para salvar no banco
		var entity = mapper.convertVoToEntity(person);
		//converte para VO para apresentar os dados;
		var vo=mapper.convertEntityToVo( repository.save(entity));
		
		return vo;
	}
	
	
	public PersonVO update (PersonVO PersonVO) {
		logger.info("Updating one PersonVO!");
		
		//recupera por id jogo na dentro da variável para modificar o objeto escolhido
		var entity=repository.findById(PersonVO.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		entity.setFirstName(PersonVO.getFirstName());
		entity.setLastName(PersonVO.getLastName());
		entity.setAddress(PersonVO.getAddress());
		entity.setGender(PersonVO.getGender());
		var vo=DozerMapper.parseObject( repository.save(entity),PersonVO.class); 
		return vo;
	}
	
	public void delete (Long id) {
		logger.info("Deleting one PersonVO");
		//recuperando a entidade a ser deletada
		var entity=repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
	

}
