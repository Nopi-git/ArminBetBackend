package com.nopi.arminBetBackend.model.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nopi.arminBetBackend.model.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pendriveSerial;

    @JsonIgnore
    private String password;

    private String username;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

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

    public Set<Role> getRoles() {
        return roles;
    }

    public Employee setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", pendriveSerial='" + pendriveSerial + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}
