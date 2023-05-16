package ru.kata.spring.boot_security.demo.mapper;

import ru.kata.spring.boot_security.demo.dto.RoleDTO;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

public interface Mapper {

    UserDTO convertTo(User user);

    RoleDTO convertTo(Role role);

}
