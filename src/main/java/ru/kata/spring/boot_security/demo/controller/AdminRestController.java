package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.mapper.Mapper;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    private final Mapper mapper;
    private final UserService userService;

    public AdminRestController(Mapper mapper, UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
    }

    @GetMapping("/users")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return new ResponseEntity<>(
                userService.getAllUsers()
                .stream().map(mapper::convertTo)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}/user")
    public ResponseEntity<UserDTO> getUserId(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user != null) {
            return new ResponseEntity<>(mapper.convertTo(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/user")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id,
                                                    @RequestBody User user) {
        userService.update(id, user);
        return new ResponseEntity<>(mapper.convertTo(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/user")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
