package com.uniyaz.service;

import com.uniyaz.domain.User;
import com.uniyaz.dao.UserDao;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User saveUser(User user) {
        User userChecked = userDao.checkExistUser(user.getName(), user.getPassword());
        if(userChecked != null){
            throw new RuntimeException("User already exist!");
        }
        else
        return userDao.saveUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }

    @Override
    public User checkExistUser(String userName, String password) {
        User userChecked = userDao.checkExistUser(userName, password);
        if(userChecked == null)
            throw new RuntimeException("User is invalid");
        else
        return userChecked;
    }
}
