package com.space.ajit.universe.controller.universe;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
public class AddressController {

    @GetMapping(value = "/address")
    public String getValue() {
        return "Address API";
    }
}
