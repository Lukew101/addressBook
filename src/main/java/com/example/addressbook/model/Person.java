package com.example.addressbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import java.util.Objects;

public class Person {
    private Long id;
    private String name;
    private String address;
    private long mobileNumber;
    public Person(Long id, String name, String address, long mobileNumber) {
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.id = id;
    }
    public Person(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
