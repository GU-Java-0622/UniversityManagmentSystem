package ru.geekbrains.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.auth.entityes.Role;
import ru.geekbrains.auth.entityes.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    User findUserById(Long id);

    @Query("select o from User o where o.id in (:id)")
    List<User> findAllUsersById(List<Long> id);


    List<User> findAllByRolesContaining(Role role);
}
