package com.example.peopledemo.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import com.example.peopledemo.dao.PersonDao;
import com.example.peopledemo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * PersonService
 * This class acts as an interface between the PersonDao and the PersonController.
 * It acts with concrete implementation directly which will be assigned using
 * annotations. Dependency Injections.
 */
@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("FakeDAO") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.addPerson(person);
    }

    public ArrayList<Person> getAllPeople() {
        return personDao.getAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.getPersonById(id);
    }

    public int deletePersonById(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person person) {
        return personDao.updatePersonById(id, person);
    }
    
}