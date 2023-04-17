package com.example.addressbook.service;

import com.example.addressbook.exception.PersonNotFoundException;
import com.example.addressbook.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
        personRepository.save(new Person(1L, "Luke Williams", "Anna Sethnes Gate 4C", 97337512));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findByName(String name) throws PersonNotFoundException {
        Optional<Person> optionalPerson = personRepository.findByName(name);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new PersonNotFoundException();
        }
    }

    public Person findById(Long id) throws PersonNotFoundException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new PersonNotFoundException();
        }
    }

    public Person createPerson(Person person){
        personRepository.save(person);
        return person;
    }

    public void updatePerson(Person person, Long id) throws PersonNotFoundException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();
            existingPerson.setName(person.getName());
            existingPerson.setAddress(person.getAddress());
            existingPerson.setMobileNumber(person.getMobileNumber());
            personRepository.save(existingPerson);
        } else {
            throw new PersonNotFoundException();
        }
    }

    public void deletePerson(Long id) {
        personRepository.findById(id)
                .ifPresent(personRepository::delete);
    }
}

