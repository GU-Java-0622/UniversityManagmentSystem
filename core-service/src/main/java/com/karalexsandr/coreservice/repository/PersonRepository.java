package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}