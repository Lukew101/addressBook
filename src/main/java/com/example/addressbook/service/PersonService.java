package com.example.addressbook.service;

import com.example.addressbook.exception.PersonNotFoundException;
import com.example.addressbook.model.PersonEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
        //personRepository.save(new PersonEntity(1L, "Luke Williams", "Anna Sethnes Gate 4C", 97337512));
    }

    public List<PersonEntity> findAll() {
        return personRepository.findAll();
    }

    public PersonEntity findByName(String name) throws PersonNotFoundException {
        Optional<PersonEntity> optionalPersonEntity = personRepository.findByName(name);
        if (optionalPersonEntity.isPresent()) {
            return optionalPersonEntity.get();
        } else {
            throw new PersonNotFoundException();
        }
    }

    public PersonEntity findById(Long id) throws PersonNotFoundException {
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);
        if (optionalPersonEntity.isPresent()) {
            return optionalPersonEntity.get();
        } else {
            throw new PersonNotFoundException();
        }
    }

    public PersonEntity createPerson(PersonEntity person){
        personRepository.save(person);
        return person;
    }

    public void updatePerson(PersonEntity person, Long id) throws PersonNotFoundException {
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);
        if (optionalPersonEntity.isPresent()) {
            PersonEntity existingPerson = optionalPersonEntity.get();
            existingPerson.setName(person.getName());
            existingPerson.setAddress(person.getAddress());
            existingPerson.setMobileNumber(person.getMobileNumber());
            personRepository.save(existingPerson);
        } else {
            throw new PersonNotFoundException();
        }
    }

    public void deletePerson(Long id) {
        boolean exists = personRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "Person with id " + id + "does not exist"
            );
        }
        personRepository.deleteById(id);
    }
}

