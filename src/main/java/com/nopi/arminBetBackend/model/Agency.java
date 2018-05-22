package com.nopi.arminBetBackend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nopi.arminBetBackend.model.control.ControlData;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Agency {

    @Id
    private Integer id;

    private String fullAddress;

    private String shortAddress;

    private String cui;

    private boolean isActive;

    @OneToMany(mappedBy = "agency")
    private List<ControlData> controls;

    public Agency() {
    }

    public Integer getId() {
        return id;
    }

    public Agency setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public Agency setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
        return this;
    }

    public String getShortAddress() {
        return shortAddress;
    }

    public Agency setShortAddress(String shortAddress) {
        this.shortAddress = shortAddress;
        return this;
    }

    public String getCui() {
        return cui;
    }

    public Agency setCui(String cui) {
        this.cui = cui;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public Agency setActive(boolean active) {
        isActive = active;
        return this;
    }

    public List<ControlData> getControls() {
        return controls;
    }

    public Agency setControls(List<ControlData> controls) {
        this.controls = controls;
        return this;
    }
}
