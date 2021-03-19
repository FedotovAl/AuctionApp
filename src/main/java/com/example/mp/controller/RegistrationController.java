package com.example.mp.controller;

import com.example.mp.entity.User;
import com.example.mp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration")
    public String show(@ModelAttribute("user") User user){
        return "registration";
    }

    @PostMapping("/registration")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         Model model){
        if (bindingResult.hasErrors()){
            return "registration";
        }
        if (userService.findByLogin(user.getLogin()) != null){
            model.addAttribute("error", "Login exists");
            return "registration";
        }

        userService.create(user);
        return "redirect:/login";
    }
}
