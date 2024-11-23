package com.example.lookup.Controller;



import com.example.lookup.Services.UserService;
import com.example.lookup.dtos.DTOToken;
import com.example.lookup.dtos.DTOUser;
import com.example.lookup.dtos.UserPorGeneroDTO;
import com.example.lookup.entities.User;
import com.example.lookup.security.JwtUtilService;
import com.example.lookup.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<User> createUser(@RequestBody DTOUser user) {
        user.setFecha_registro(new Date());
        User newUser = userService.register(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }


    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody DTOUser user) {
        User newUser = userService.changePassword(user);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }



    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<List<User>>(userService.list(), HttpStatus.OK);
    }

    @PostMapping("/users/login")
    public ResponseEntity<DTOToken> authenticate(@RequestBody DTOUser user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getNombre_Usuario(),
                        user.getPassword()));
        SecurityUser securityUser = (SecurityUser) this.userDetailsService.loadUserByUsername(
                user.getNombre_Usuario());
        String jwt = jwtUtilService.generateToken(securityUser);
        User id = securityUser.getUser();
        return new ResponseEntity<DTOToken>(new DTOToken(jwt, id), HttpStatus.OK);

    }

    @GetMapping("/userPorGenero")
    public List<UserPorGeneroDTO> usuariosPorGenero() {
        return userService.usuariosPorGenero();
    }
}
