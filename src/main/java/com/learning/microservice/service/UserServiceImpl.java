package com.learning.microservice.service;

import com.learning.microservice.model.User;
import com.learning.microservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserByName(String username){
        return userRepository.findByUsername(username);
    }
    @Override
    public List<User> getUserListByIds(List<Long> ids) {
        return userRepository.findAllById(ids);
    }


}
