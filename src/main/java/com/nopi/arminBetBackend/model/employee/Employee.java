package com.nopi.arminBetBackend.model.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pendriveSerial;

    @JsonIgnore
    private String password;

    private String username;

    public Employee() {
    }

    public Employee(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPendriveSerial() {
        return pendriveSerial;
    }

    public Employee setPendriveSerial(String pendriveSerial) {
        this.pendriveSerial = pendriveSerial;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Employee setUsername(String username) {
        this.username = username;
        return this;
    }

}
