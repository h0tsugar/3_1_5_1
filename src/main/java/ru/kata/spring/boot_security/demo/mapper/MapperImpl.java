package ru.kata.spring.boot_security.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dto.RoleDTO;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

@Component
public class MapperImpl implements Mapper {

    @Override
    public UserDTO convertTo(User user) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public RoleDTO convertTo(Role role) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(role, RoleDTO.class);
    }
}
