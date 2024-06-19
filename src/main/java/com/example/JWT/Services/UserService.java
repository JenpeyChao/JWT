package com.example.JWT.Services;

import com.example.JWT.Entity.Users;
import com.example.JWT.Repository.UserDAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = userDAO.findByUsername(username);
        return users.map(UsersDetail::new).orElseThrow(()->new UsernameNotFoundException("User Does Not Exist"));
    }
    public String addUser(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        this.userDAO.save(users);
        return "User added";

    }
}
