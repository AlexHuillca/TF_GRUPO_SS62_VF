package com.example.lookup.ServiceImplements;


import com.example.lookup.entities.User;
import com.example.lookup.repository.UserRepository;
import com.example.lookup.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user !=null) {
            return new SecurityUser(user);
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
