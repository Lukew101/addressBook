package com.example.addressbook.service;

import com.example.addressbook.model.Person;

import com.example.addressbook.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByName(String name);
    // Any methods not provided by JpaRepository must be declared in here to be used in the Service class.
}
