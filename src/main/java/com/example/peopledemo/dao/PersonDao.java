package com.example.peopledemo.dao;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import com.example.peopledemo.model.Person;

/**
 * PersonDao 
 * This is like a contract that any class will have to follow in order to implement the following 
 * methods compulsory, so there is uniformity and then we can have multiple database implementations
 * which will be consistent. 
 * Helps in dependency injection.
 */

public interface PersonDao {

    int addPerson(UUID id, Person person);

    default int addPerson(Person person) {
        UUID id = UUID.randomUUID();
        return addPerson(id, person);
    }

    ArrayList<Person> getAllPeople();

    Optional<Person> getPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}