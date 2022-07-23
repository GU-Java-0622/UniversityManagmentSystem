package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.dto.person.PersonDtoResponse;
import com.karalexsandr.coreservice.entity.Person;
import liquibase.pro.packaged.Q;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select new com.karalexsandr.coreservice.dto.person.PersonDtoResponse" +
            "(p.userId,p.firstName,p.lastName,p.surname)" +
            "from Person p where p.userId=?1")
    Optional<PersonDtoResponse> findByUserId(Long id);
}