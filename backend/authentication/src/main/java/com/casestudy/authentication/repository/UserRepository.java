package com.casestudy.authentication.repository;

import com.casestudy.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByEmail(String email);
    public User findByPhn(String phn);
    public User findByEmailAndPassword(String email,String password);


}
