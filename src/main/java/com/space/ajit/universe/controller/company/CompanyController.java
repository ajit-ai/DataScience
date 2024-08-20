package com.space.ajit.universe.controller.company;


import com.space.ajit.universe.model.company.Company;
import com.space.ajit.universe.service.CompanyService;
import com.space.ajit.universe.validator.CompanyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class CompanyController {

    @Autowired
    CompanyValidator companyValidator;

    @Autowired
    CompanyService companyService;

    @GetMapping("/company")
    public String getValue() {
        return "Company API";
    }

    @PostMapping("/create")
    public ResponseEntity<?> findById(@Valid @RequestBody Company company, Errors errors) {


        companyValidator.validate(company,errors);

        if (errors.hasErrors()) {
            return new ResponseEntity<>(createErrorString(errors),HttpStatus.BAD_REQUEST);
        }


        /*if (bindingResult.hasErrors()) {

            Map<String,String> map = new HashMap<String,String>();
            MapBindingResult err = new MapBindingResult(map, Company.class.getName());
            companyValidator.validate(company, err);
            List<ObjectError> list = err.getAllErrors();
            for(ObjectError objErr : list){
                System.out.println(objErr.getDefaultMessage());
            }
        }*/

        /*Errors errors = new BeanPropertyBindingResult(userDetails, "object");
         *//* if (bindingResult.hasErrors()) {
            throw new UserDetailsException("User detail have error");
        }*//*

        errors.hasErrors();*/

        Company companys = companyService.save(company);
        return new ResponseEntity<Company>(companys, HttpStatus.CREATED);
    }


    private String createErrorString(Errors errors) {
        return errors.getAllErrors().stream().map(ObjectError::toString).collect(Collectors.joining(","));
    }
    @GetMapping(value = "/companys")
    public ResponseEntity<List<Company>> getCompany() {

        List<Company> companies = companyService.getCompany();
        return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
    }


}
