package pl.sda.eventservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.eventservice.controller.dto.UserDto;
import pl.sda.eventservice.model.User;
import pl.sda.eventservice.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    UserService userService;

    // wstrzyknięcie zależności przez konstruktor
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new UserDto());
        return "registerForm";
    }

    // obsługa wysłanego formularza
    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserDto userDto,
                           BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "registerForm";
        }

        userService.saveUser(userDto);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(String email, String password) {
        //return "loginForm";
        User loggedUser = userService.loginUser(email, password);
        if (loggedUser != null) {
            return "You are logged in.";
        }
        return "User does not exist.";
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
