package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private RegistrationService registrationService;

    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService()
                                  .getUserRepository()
                                  .getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.getDataProcessingService().getUserRepository().getUsers().add(user);
        return "User added from body!";
    }

    @PostMapping("/param")
    public String userAddFromBody(@RequestParam("name") String name,
                                  @RequestParam("age") int age,
                                  @RequestParam("email") String email) {
        registrationService.processRegistration(name, age, email);
        return "User added from params!";
    }
}
