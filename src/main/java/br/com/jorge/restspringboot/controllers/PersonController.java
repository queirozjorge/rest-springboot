package br.com.jorge.restspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jorge.restspringboot.VO.v1.PersonVO;
import br.com.jorge.restspringboot.VO.v2.PersonVOV2;
import br.com.jorge.restspringboot.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices personServices;

	@GetMapping(path = "/{id}")
	public PersonVO findById(@PathVariable(name = "id") long id) {
		return personServices.findById(id);
	}

	@GetMapping("/list")
	public List<PersonVO> findAll() {
		return personServices.findAll();
	}

	@PostMapping("/new")
	public PersonVO save(@RequestBody PersonVO person) {
		return personServices.create(person);
	}
	
	@PostMapping("/v2/new")
	public PersonVOV2 saveV2(@RequestBody PersonVOV2 person) {
		return personServices.createV2(person);
	}

	@PutMapping("/update")
	public PersonVO update(@RequestBody PersonVO person) {
		return personServices.update(person);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
		personServices.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
