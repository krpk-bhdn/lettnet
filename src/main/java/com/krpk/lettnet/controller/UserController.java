package com.krpk.lettnet.controller;

import com.krpk.lettnet.domain.User;
import com.krpk.lettnet.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserDetailsRepo userDetailsRepo;

    @Autowired
    public UserController(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") User user) {
        return user;
    }

    @PutMapping("{id}")
    public User updateUser(
            @PathVariable("id") User userFromDb,
            @RequestBody Map<String, String> user
    ) {

        for (String key : user.keySet()) {
            switch (key) {
                case "name": {
                    userFromDb.setName(user.get(key));
                    break;
                }
                case "bio": {
                    userFromDb.setBio(user.get(key));
                    break;
                }
                case "headline": {
                    userFromDb.setHeadline(user.get(key));
                    break;
                }
                case "locale": {
                    userFromDb.setLocale(user.get(key));
                    break;
                }
            }
        }

        return userDetailsRepo.save(userFromDb);
    }
}
