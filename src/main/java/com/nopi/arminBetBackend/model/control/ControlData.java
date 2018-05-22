package com.nopi.arminBetBackend.model.control;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nopi.arminBetBackend.model.Agency;
import com.nopi.arminBetBackend.model.employee.Employee;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ControlData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"cui", "shortAddress", "fullAddress", "controls"})
    @JoinColumn(name = "arm_id")
    private Agency agency;

    private String description;

    private String errorDescription;

    private String publicIp;

    private String motherBoardSerial;

    private java.sql.Timestamp date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"username", "password", "pendriveSerial", "controlData"})
    private Employee employee;

    private String location;

    private String lastBootUpTime;

    private String controlType;

    private String newInstall;

    @OneToOne(cascade = CascadeType.ALL)
    private ControlFinancialData controlFinancialData;

    public ControlData() {
    }

    public Long getId() {
        return id;
    }

    public ControlData setId(Long id) {
        this.id = id;
        return this;
    }

    public Agency getAgency() {
        return agency;
    }

    public ControlData setAgency(Agency agency) {
        this.agency = agency;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ControlData setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public ControlData setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public ControlData setPublicIp(String publicIp) {
        this.publicIp = publicIp;
        return this;
    }

    public String getMotherBoardSerial() {
        return motherBoardSerial;
    }

    public ControlData setMotherBoardSerial(String motherBoardSerial) {
        this.motherBoardSerial = motherBoardSerial;
        return this;
    }

    public Timestamp getDate() {
        return date;
    }

    public ControlData setDate(Timestamp date) {
        this.date = date;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ControlData setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ControlData setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getLastBootUpTime() {
        return lastBootUpTime;
    }

    public ControlData setLastBootUpTime(String lastBootUpTime) {
        this.lastBootUpTime = lastBootUpTime;
        return this;
    }

    public String getControlType() {
        return controlType;
    }

    public ControlData setControlType(String controlType) {
        this.controlType = controlType;
        return this;
    }

    public String getNewInstall() {
        return newInstall;
    }

    public ControlData setNewInstall(String newInstall) {
        this.newInstall = newInstall;
        return this;
    }

    public ControlFinancialData getControlFinancialData() {
        return controlFinancialData;
    }

    public ControlData setControlFinancialData(ControlFinancialData controlFinancialData) {
        this.controlFinancialData = controlFinancialData;
        return this;
    }
}