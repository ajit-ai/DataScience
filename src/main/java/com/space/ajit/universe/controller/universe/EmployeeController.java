package com.space.ajit.universe.controller.universe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @GetMapping(value = "/employee")
    public String getValue() {
        return "Employee API";
    }
}
