package com.casestudy.authentication.service;

import com.casestudy.authentication.model.User;
import com.casestudy.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl() {
    }


    @Override
    public boolean isUserPresent(User user) {
        boolean userExists = false;
        //String message = null;
        User existingUserEmail = userRepository.findByEmail(user.getEmail());
        if(existingUserEmail!=null){
            userExists = true;
            //message = "Email Already Present!";
        }
        User existingUserMobile = userRepository.findByPhn(user.getPhn());
        if(existingUserMobile!=null){
            userExists = true;
            //message = "Mobile Number Already Present!";
        }

        return userExists;
    }


    @Override
    public User save(User user) {
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//
//        user.setPassword(encodedPassword);
        user.setUsertype("ROLE_USER");
        return userRepository.save(user);

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userid) {
        return userRepository.findById(userid).get();
    }

    @Override
    public User fetchUserByEmailAndPassword(String loginemail, String loginpassword) {
        User user=userRepository.findByEmailAndPassword(loginemail,loginpassword);
        return user;
    }
}
