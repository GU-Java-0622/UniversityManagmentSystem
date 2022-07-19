package ru.geekbrains.auth.payload.response;


import ru.geekbrains.auth.entityes.User;
import web.entity.UserStatus;

public class ProfileGetAllDtoResponse {
    private Long id;
    private String firstname;
    private String surname;
    private String lastname;
    private UserStatus status;
    private boolean isEmailVerified =false;

    public ProfileGetAllDtoResponse() {
    }

    public ProfileGetAllDtoResponse(Long id, String firstname, String surname, String lastname, UserStatus status) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.lastname = lastname;
        this.status = status;
    }
    public ProfileGetAllDtoResponse(User profile) {
        this.id = profile.getId();
        this.firstname = profile.getFirstname();
        this.surname = profile.getSurname();
        this.lastname = profile.getMiddlename();
        this.status = profile.getStatus();
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

}
