package com.nopi.arminBetBackend.model.employee;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nopi.arminBetBackend.model.control.ControlData;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "employee")
    private List<ControlData> controlData;

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

    public List<ControlData> getControlData() {
        return controlData;
    }

    public Employee setControlData(List<ControlData> controlData) {
        this.controlData = controlData;
        return this;
    }

    public void addControl(ControlData controlData){
        this.controlData.add(controlData);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", pendriveSerial='" + pendriveSerial + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", controlData=" + controlData +
                '}';
    }
}
