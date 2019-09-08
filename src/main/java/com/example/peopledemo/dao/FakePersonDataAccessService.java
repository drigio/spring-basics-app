package com.example.peopledemo.dao;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import com.example.peopledemo.model.Person;

import org.springframework.stereotype.Repository;

/**
 * FakePersonDataAccessService 
 * Implementation of an in-memory Database for temporary purpose.
 */
@Repository("FakeDAO")
public class FakePersonDataAccessService implements PersonDao {

    public static ArrayList<Person> DB = new ArrayList<Person>();

    @Override
    public int addPerson(UUID id, Person person) {
        DB.add(
            new Person(id,
            person.getFname(),
            person.getLname(),
            person.getAge())
            );
        return 1;
    }

    @Override
    public ArrayList<Person> getAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return DB.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = getPersonById(id);
        if(!person.isPresent()) {
            return 0;
        } 
        DB.remove(person.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        Optional<Person> personMaybe = getPersonById(id);
        if(!personMaybe.isPresent()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        addPerson(id,person);
        return 1;
    }

    
}