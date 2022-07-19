package ru.geekbrains.com.entity;

import javax.persistence.*;
@Table(name = "profile")
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")/*имя*/
    private String firstname;

    @Column(name = "surname")/*фамилия*/
    private String surname;

    @Column(name = "lastname")/*отчество*/
    private String lastname;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProfileStatus status;

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

    public ProfileStatus getStatus() {
        return status;
    }

    public void setStatus(ProfileStatus status) {
        this.status = status;
    }
}
