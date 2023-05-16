package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.mapper.Mapper;
import ru.kata.spring.boot_security.demo.models.User;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final Mapper mapper;

    public UserRestController(Mapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<UserDTO> showAuthUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(mapper.convertTo(user));
    }

}
