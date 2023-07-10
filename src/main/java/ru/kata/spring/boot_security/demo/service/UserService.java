package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void deleteById(Long id);
    List<User> getAllUsers();
    User findById(Long id);
    void update(Long id, User updatedUser);

}
