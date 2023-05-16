package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.dto.RoleDTO;
import ru.kata.spring.boot_security.demo.mapper.Mapper;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class RoleRestController {

    private final UserService userService;
    private final RoleService roleService;
    private final Mapper mapper;

    public RoleRestController(UserService userService, RoleService roleService, Mapper mapper) {
        this.userService = userService;
        this.roleService = roleService;
        this.mapper = mapper;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return new ResponseEntity<>(
                roleService.getAllRoles()
                        .stream()
                        .map(mapper::convertTo)
                        .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}/roles")
    public ResponseEntity<RoleDTO> getRoles(@PathVariable("id") Long id) {
        Role roles = (Role) userService.findById(id).getRoles();
        RoleDTO roleDTO = mapper.convertTo(roles);
        return new ResponseEntity<>(roleDTO, HttpStatus.OK);
    }

}
