package com.example.mp.controller;

import com.example.mp.entity.User;
import com.example.mp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    @GetMapping()
    public String show(@ModelAttribute("user") User user){
        return "registration";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.create(user);
        return "redirect:/login";
    }
}
