package ru.chelserg.btstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.chelserg.btstrap.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
private final UserService userService;

@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userProfile(Principal principal, Model model) {
    String username = principal.getName();

    model.addAttribute("user", userService.findUserByUsername(username));
    model.addAttribute("role", userService.findUserByUsername(username).getRoles());
    return "user/profile";
    }
}
