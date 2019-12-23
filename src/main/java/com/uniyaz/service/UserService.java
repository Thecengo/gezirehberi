package com.uniyaz.service;

import com.uniyaz.domain.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUser();
    public User checkExistUser(String userName, String password);

}
