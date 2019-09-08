package com.example.peopledemo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Person Model Class
 */
public class Person {

    private UUID id;
    private String fname;
    private String lname;
    private int age;

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