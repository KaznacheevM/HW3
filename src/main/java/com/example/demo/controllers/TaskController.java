package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.service.DataProcessingService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private DataProcessingService dataProcessingService;

    public TaskController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    @GetMapping
    public List<String> getTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");

        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return dataProcessingService.sortUsersByAge(
                dataProcessingService.getUserRepository().getUsers()
        );
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return dataProcessingService.filterUsersByAge(
                dataProcessingService.getUserRepository().getUsers(),
                age
        );
    }

    @GetMapping("/calc")
    public double calculateAverageAge() {
        return dataProcessingService.calculateAverageAge(
                dataProcessingService.getUserRepository().getUsers()
        );
    }
}
