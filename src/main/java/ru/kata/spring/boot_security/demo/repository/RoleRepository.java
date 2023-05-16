package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "from Role as r where r.name = :name")
    Optional<Role> findByNameRole(@Param("name") String name);
}
