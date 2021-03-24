package com.example.mp.controller;

import com.example.mp.entity.User;
import com.example.mp.service.SecurityService;
import com.example.mp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class AdminController {

    private final UserService userService;
    private final SecurityService securityService;

    @GetMapping()
        public String showUsers(Model model){
            User authUser = securityService.getAuthUser();
            if (!authUser.getRole().getName().equals("ADMIN")){
                return "redirect:/";
            }
            List<User> users = userService.findAll();
            users.sort(Comparator.comparing(User::getId));
            model.addAttribute("users", users);
            model.addAttribute("authUser", authUser);
            return "users";
    }
}
