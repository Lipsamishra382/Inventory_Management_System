package com.casestudy.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    private int userid;

    @Column(name="Name",nullable = false)
    private String name;

    @Column(name="Email_Address",nullable = false)
    private String email;

    @Column(name="Password",nullable = false)
    private String password;

    @Column(name="Contact_No",nullable = false)
    private String phn;

    @Column(name="DOB",nullable = false)
    private String dob;

    @Column(name="UserType",nullable = false)
    private String usertype;

}
