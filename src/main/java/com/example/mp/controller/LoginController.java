package com.example.mp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class LoginController {

    @GetMapping("/login")
    public String show(@RequestParam(name = "error", required = false) Boolean error,
                                Model model){
        if (Boolean.TRUE.equals(error)){
            model.addAttribute("error", error);
        }
        return "login";
    }
}
