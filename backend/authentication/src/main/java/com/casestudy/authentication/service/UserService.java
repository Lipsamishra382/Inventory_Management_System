package com.casestudy.authentication.service;

import com.casestudy.authentication.model.User;

import java.util.List;

public interface UserService {

    public boolean isUserPresent(User user);

    public User save(User user);
    public List<User> getUsers();
    public User getUserById(int userid);

    User fetchUserByEmailAndPassword(String loginemail, String loginpassword);
}
