package com.space.ajit.universe.controller.company;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class CompanyController {

    @GetMapping("/company")
    public String getValue() {
        return "Company API";
    }
}
