package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kata.spring.boot_security.demo.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "from User as u where u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
