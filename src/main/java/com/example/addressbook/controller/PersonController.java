package com.example.addressbook.controller;

import com.example.addressbook.exception.PersonNotFoundException;
import com.example.addressbook.model.Person;
import com.example.addressbook.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping(params = "name")
    public Person findByName(@RequestParam String name) throws PersonNotFoundException {
        return personService.findByName(name);
    }

    @GetMapping(params = "id")
    public Person findById(@RequestParam Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Person createPerson(@Validated @RequestBody Person person){
        return personService.createPerson(person);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updatePerson(@Validated @RequestBody Person person,@PathVariable Long id) throws PersonNotFoundException {
        personService.updatePerson(person, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(params = "id")
    public void deletePerson(@RequestParam Long id) {
        personService.deletePerson(id);
    }
}

