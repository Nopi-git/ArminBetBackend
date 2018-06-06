package com.nopi.arminBetBackend.model.employee;

public class UserDetails {


    private String pendriveSerial;

    private String password;

    private String username;

    public String getPendriveSerial() {
        return pendriveSerial;
    }

    public UserDetails setPendriveSerial(String pendriveSerial) {
        this.pendriveSerial = pendriveSerial;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDetails setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDetails setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "pendriveSerial='" + pendriveSerial + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
