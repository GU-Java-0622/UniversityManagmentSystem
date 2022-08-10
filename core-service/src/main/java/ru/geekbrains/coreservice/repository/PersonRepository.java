package ru.geekbrains.coreservice.repository;

import ru.geekbrains.coreservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}