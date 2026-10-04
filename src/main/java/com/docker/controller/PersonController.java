package com.docker.controller;
import com.docker.entity.Person;

import com.docker.dto.PersonDTO;
import com.docker.service.PersonService;
import com.docker.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    private final PersonRepository personRepo;

    @GetMapping("/")
    public ResponseEntity<?> getTestPersons() {
        return new ResponseEntity<>("HI", HttpStatus.OK);
    }
	
    @GetMapping("/getAll")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }
	
	
	@GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {

        Optional<Person> personData = personRepo.findById(id);
        if (personData.isPresent()) {
            return new ResponseEntity<>(personData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person personObj = personRepo.save(person);

        return new ResponseEntity<>(personObj, HttpStatus.OK);
    }
	
	@PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePersonById(@PathVariable Long id, @RequestBody Person person) {
        Optional<Person> oldPersonData = personRepo.findById(id);
        if (oldPersonData.isPresent()) {
            Person updatedPersonData = oldPersonData.get();
            updatedPersonData.setFirstName(person.getFirstName());
            updatedPersonData.setCountry(person.getCountry());
            personRepo.save(updatedPersonData);

            Person personObj = personRepo.save(updatedPersonData);
            return new ResponseEntity<>(personObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<PersonDTO> deletePersonById(@PathVariable Long id) {
        personRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
	
	
	
}
