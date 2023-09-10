package com.learning.microservice.service;

import com.learning.microservice.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    User getUserByName(String username);

    public List<User> getUserListByIds(List<Long> ids);
}
