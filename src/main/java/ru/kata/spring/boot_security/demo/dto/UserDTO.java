package ru.kata.spring.boot_security.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.kata.spring.boot_security.demo.models.Role;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String lastName;

    private int age;

    private String email;

    private String password;

    private Set<Role> roles;

    public UserDTO(Long id, String username, String lastName, int age, String email, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public String getShortRole() {
        return roles.toString().substring(1, roles.toString().length() - 1);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
