package com.krpk.lettnet.controller;

import com.krpk.lettnet.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping
    public String main(
            @AuthenticationPrincipal User user,
            Model model
    ){
        HashMap<Object, Object> data = new HashMap<>();

        if (user != null) {
            data.put("profile", user);
        }

        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));
        return "index";
    }

}
