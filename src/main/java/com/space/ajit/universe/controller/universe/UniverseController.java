package com.space.ajit.universe.controller.universe;


import com.space.ajit.universe.exception.UniverseNotFound;
import com.space.ajit.universe.model.company.Company;
import com.space.ajit.universe.model.universe.Universe;
import com.space.ajit.universe.model.universe.UserDetails;
import com.space.ajit.universe.service.UniverseService;
import com.space.ajit.universe.validator.UniverseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UniverseController {

    @Autowired
    UniverseValidator universeValidator;

    @Autowired
    UniverseService universeService;


    @GetMapping(value = "/universe", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String get() {
        return "Universe API";
    }

    @PostMapping("/createUniverse")
    public ResponseEntity<?> createUniverse(@Valid @RequestBody Universe universe, Errors errors) {


        universeValidator.validate(universe,errors);

        if (errors.hasErrors()) {
            return new ResponseEntity<>(createErrorString(errors), HttpStatus.BAD_REQUEST);
        }

        Universe universes = universeService.save(universe);
        return new ResponseEntity<>(universes, HttpStatus.CREATED);
    }


    private String createErrorString(Errors errors) {
        return errors.getAllErrors().stream().map(ObjectError::toString).collect(Collectors.joining(","));
    }
    @GetMapping(value = "/getUniverse")
    public ResponseEntity<List<Universe>> getUniverse() {

        List<Universe> universes = universeService.getUniverse();
        return new ResponseEntity<List<Universe>>(universes,HttpStatus.OK);
    }

    @PutMapping("/updateUniverse/{id}")
    public ResponseEntity<Universe> updateUniverse(@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody Universe universe) throws UniverseNotFound {
        Optional<Universe> universe1 = universeService.findById(id);
        if((universe1.isPresent())) {

           // universe.
            final Universe updatedUniverse;
            updatedUniverse = universeService.save(universe);
            //return ResponseEntity.ok(updatedUniverse);
            return new ResponseEntity <>(updatedUniverse,HttpStatus.CREATED);

        } else
        {
            throw new UniverseNotFound("Universe id not found" + universe1.isPresent());
        }



       /* *//*employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());*//*
        final Universe updatedUniverse;
        updatedUniverse = universeService.save(universe);
        //return ResponseEntity.ok(updatedUniverse);
        return new ResponseEntity <>(updatedUniverse,HttpStatus.CREATED);*/
    }

}
