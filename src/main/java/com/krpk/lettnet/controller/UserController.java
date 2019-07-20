package com.krpk.lettnet.controller;

import com.krpk.lettnet.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") User user) {
        return user;
    }
}
