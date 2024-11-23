package com.example.lookup.Services;

import com.example.lookup.dtos.DTOUser;
import com.example.lookup.dtos.UserPorGeneroDTO;
import com.example.lookup.entities.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface UserService {
    public User findById(Long id);
    public User register(DTOUser user);
    public User changePassword(DTOUser user);
    public List<User> list();
    public List<UserPorGeneroDTO> usuariosPorGenero();
}
