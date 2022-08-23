package com.test.hib.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DEPT")
public class Department {
    private int did;
    private String name;
    private String state;

    public Department() {

    }

    public Department(String name, String state) {
        this.name = name;
        this.state = state;
    }

    @Column(name = "DEPT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
