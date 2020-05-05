package com.space.ajit.universe.controller.universe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api")
public class CountryController {

    @RequestMapping(name = "/country")
    public String getValue() {
        return "Country API";

    }

}
