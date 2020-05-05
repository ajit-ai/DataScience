package com.space.ajit.universe.controller.universe;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UniverseController {


    @GetMapping(value = "/universe", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String get() {
        return "Universe API";
    }

}
