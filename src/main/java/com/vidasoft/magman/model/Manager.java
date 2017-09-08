package com.vidasoft.magman.model;

public class Manager extends User {

    public Manager() {
    }

    public Manager(String userName, String password, String firstName,
                   String lastName, String email) {
        super(userName, password, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "userName='" + getUserName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() +
                "}";
    }
}
