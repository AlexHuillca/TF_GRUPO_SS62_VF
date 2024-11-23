package com.example.lookup.ServiceImplements;



import com.example.lookup.Services.UserService;
import com.example.lookup.dtos.DTOUser;
import com.example.lookup.dtos.UserPorGeneroDTO;
import com.example.lookup.entities.AuthorityName;
import com.example.lookup.entities.User;
import com.example.lookup.exceptions.IncompleteDataException;
import com.example.lookup.exceptions.KeyRepeatedDataException;
import com.example.lookup.exceptions.ResourceNotFoundException;
import com.example.lookup.repository.AuthorityRepository;
import com.example.lookup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public User findById(Long id) {
        User userFound = userRepository.findById(id).orElse(null);
        if (userFound == null) {
            throw new ResourceNotFoundException("There are no User with the id: "+String.valueOf(id));
        }
        return userFound;
    }

    @Override
    public User register(DTOUser user) {

        if (user.getNombre_Usuario().length()>4 && user.getPassword().length()>4) {

            User userFound = userRepository.findByUserName(user.getNombre_Usuario());
            if (userFound != null) {
                throw new KeyRepeatedDataException("User name can not be duplicated");
            };

            User newUser = new User();
            newUser.setNombre_Usuario(user.getNombre_Usuario());

            newUser.setFecha_registro(user.getFecha_registro());

            newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            newUser.setEnabled(true);
            newUser.setEdad(user.getEdad());
            newUser.setCorreo(user.getCorreo());
            newUser.setDireccion(user.getDireccion());
            newUser.setDni(user.getDni());
            newUser.setGenero(user.getGenero());
            AuthorityName authorityName=AuthorityName.ROLE_CLIENTE;
            if (user.getType().equals("ROLE_CLIENTE")) authorityName= AuthorityName.ROLE_CLIENTE;
            if (user.getType().equals("ROLE_ADMIN")) authorityName= AuthorityName.ROLE_ADMIN;
            newUser.setAuthorities(
                    List.of(
                            authorityRepository.findByName(authorityName)
                    )
            );

            return userRepository.save(newUser);
        } else {
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }

    @Override
    public User changePassword(DTOUser user) {
        if (user.getNombre_Usuario().length()>4 && user.getPassword().length()>4) {

            User userFound = userRepository.findByUserName(user.getNombre_Usuario());
            if (userFound == null) {
                throw new ResourceNotFoundException("User name can not be found");
            };

            userFound.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            return userRepository.save(userFound);
        } else {
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public List<UserPorGeneroDTO> usuariosPorGenero() {
        return userRepository.usuariosPorGenero();
    }


}

//un usuario no puede tener la contraseña o nombre de usuario menor que 4 digitos
