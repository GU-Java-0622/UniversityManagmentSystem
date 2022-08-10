package ru.geekbrains.coreservice.repository;

import ru.geekbrains.coreservice.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

}