package ru.geekbrains.commons.entity;


import java.util.HashSet;
import java.util.Set;

public class ProfileDto {
    private Long id;
    private String firstname;
    private String surname;
    private String middlename;
    private String email;
    private Set<ERole> roles = new HashSet<>();

    public ProfileDto() {
    }

    public ProfileDto(Long id, String firstname, String surname, String middlename, String email, Set<ERole> roles) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.middlename = middlename;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ERole> getRoles() {
        return roles;
    }

    public void setRoles(Set<ERole> roles) {
        this.roles = roles;
    }
}

