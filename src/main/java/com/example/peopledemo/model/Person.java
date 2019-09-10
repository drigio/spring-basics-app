package com.example.peopledemo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.beans.factory.annotation.Required;

/**
 * Person Model Class
 */
public class Person {

    private final UUID id;
    private final String fname;
    private final String lname;
    private final int age;

    public Person(@JsonProperty("id") UUID id,
                @JsonProperty("fname") String fname,
                @JsonProperty("lname") String lname,
                @JsonProperty("age") int age) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

	public UUID getId() {
        return this.id;
    }


    public String getFname() {
        return this.fname;
    }


    public String getLname() {
        return this.lname;
    }


    public int getAge() {
        return this.age;
    }

}