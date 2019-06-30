package pl.sda.eventservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.eventservice.controller.dto.UserDto;
import pl.sda.eventservice.model.User;
import pl.sda.eventservice.service.UserService;

import javax.validation.Valid;

@RestController
public class UserController {
    UserService userService;

    // wstrzyknięcie zależności przez konstruktor
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // obsługa wysłanego formularza
    @PostMapping("/register")
    public void register(@ModelAttribute("user") @Valid UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/login")
    public String login(String email, String password) {
        User loggedUser = userService.loginUser(email, password);
        if (loggedUser != null) {
            return "You are logged in.";
        }
        return "User does not exis.";
    }

    @PutMapping("/addAdmin/{id}")
    public void makeAdmin(@PathVariable Long id) {
        userService.addAdmin(id);
    }

    @PutMapping("/addUser/{id}")
    public void makeUser(@PathVariable Long id) {
        userService.addUser(id);
    }
}
