package com.example.allinone1.entities;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String lastName;
    private String address;

    public Person(String name, String lastName, String address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}
