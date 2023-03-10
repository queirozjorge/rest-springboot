package br.com.jorge.restspringboot.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jorge.restspringboot.VO.v1.PersonVO;
import br.com.jorge.restspringboot.VO.v2.PersonVOV2;
import br.com.jorge.restspringboot.exceptions.ResourceNotFoundException;
import br.com.jorge.restspringboot.mapper.DozerMapper;
import br.com.jorge.restspringboot.mapper.custom.PersonMapper;
import br.com.jorge.restspringboot.models.Person;
import br.com.jorge.restspringboot.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all people.");
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		logger.info("Finding Person by id.");
		return DozerMapper.parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID.")), PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating a Person.");
		var entity = DozerMapper.parseObject(person, Person.class);
		repository.save(entity);
		var vo = DozerMapper.parseObject(entity, PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Creating a Person.");
		var entity = mapper.convertVoToEntity(person);
		repository.save(entity);
		var vo = mapper.convertEntityToVo(entity);
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating a Person.");
		var entity = DozerMapper.parseObject(person, Person.class);
		repository.save(entity);
		var vo = DozerMapper.parseObject(entity, PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting a PersonVO.");
		var entity = DozerMapper.parseObject(findById(id), Person.class);
		repository.delete(entity);
	}
}
