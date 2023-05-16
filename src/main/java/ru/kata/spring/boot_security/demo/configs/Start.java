package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class
Start implements ApplicationListener<ContextRefreshedEvent> {

    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public Start(RoleRepository roleRepository, PasswordEncoder encoder, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role("ROLE_USER");
        if (roleRepository.findByNameRole(admin.getName()).isEmpty()) {
            roleRepository.save(admin);
        }
        if (roleRepository.findByNameRole(user.getName()).isEmpty()) {
            roleRepository.save(user);
        }
        Set<Role> role1 = new HashSet<>();
        role1.add(user);
        role1.add(admin);
        Set<Role> role2 = Set.of(user);
        User admin1 = new User("admin", "adminov", 24, "admin@gmail.com",
                encoder.encode("password"), role1);
        if (userRepository.findByUsername(admin1.getUsername()).isEmpty()) {
            userRepository.save(admin1);
        }
        User user1 = new User("user", "userov", 23, "user@gmail.com",
                encoder.encode("password"), role2);
        if (userRepository.findByUsername(user1.getUsername()).isEmpty()) {
            userRepository.save(user1);
        }

    }
}
