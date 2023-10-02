package com.casestudy.authentication.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/home",method={ RequestMethod.GET, RequestMethod.POST })
    public String home() {

        return "Admin Dashboard";
    }
}
