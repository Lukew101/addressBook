package com.example.addressbook.controller;

import com.example.addressbook.exception.PersonNotFoundException;
import com.example.addressbook.model.PersonEntity;
import com.example.addressbook.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController implements PersonControllerInterface{

    // Use @AutoWired if having multiple constructors so Spring can auto determine constructor used for dependency injection
    // Better to use constructor injection if there is ONE constructor in the class

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<PersonEntity> findAll() {
        return personService.findAll();
    }

    @GetMapping(params = "name")
    public PersonEntity findByName(@RequestParam String name) throws PersonNotFoundException {
        return personService.findByName(name);
    }

    @GetMapping(params = "id")
    public PersonEntity findById(@RequestParam Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PersonEntity createPerson(@Validated @RequestBody PersonEntity person){
        return personService.createPerson(person);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updatePerson(@Validated @RequestBody PersonEntity person,@PathVariable Long id) throws PersonNotFoundException {
        personService.updatePerson(person, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}

