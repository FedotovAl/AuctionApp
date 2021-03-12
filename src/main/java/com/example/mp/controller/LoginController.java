package com.example.mp.controller;

import com.example.mp.entity.User;
import com.example.mp.service.UserService;
import com.example.mp.test.TestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @GetMapping()
    public String show(@ModelAttribute("user") User user){
        return "login";
    }
    @PostMapping()
    public String login(@ModelAttribute("user") User loggingUser){
        User user = userService.findByLogin(loggingUser.getLogin());
        if (user != null && user.getPassword().equals(loggingUser.getPassword())) {
            TestUser.login(user);
            TestUser.isLogin = true;
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
