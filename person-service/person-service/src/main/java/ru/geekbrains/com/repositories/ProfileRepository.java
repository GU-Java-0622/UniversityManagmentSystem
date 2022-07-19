package ru.geekbrains.com.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.com.entity.Profile;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Long>, JpaSpecificationExecutor<Profile> {

    Optional<Profile> findByFirstname(String userName);
}
