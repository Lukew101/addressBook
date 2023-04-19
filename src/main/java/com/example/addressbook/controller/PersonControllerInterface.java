package com.example.addressbook.controller;

import com.example.addressbook.exception.PersonNotFoundException;
import com.example.addressbook.model.PersonEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PersonControllerInterface {
    List<PersonEntity> findAll();

    PersonEntity findByName(String name) throws PersonNotFoundException;

    PersonEntity findById(Long id) throws PersonNotFoundException;

    PersonEntity createPerson(PersonEntity person);

    void updatePerson(PersonEntity person, Long id) throws PersonNotFoundException;

    void deletePerson(Long id);
}
