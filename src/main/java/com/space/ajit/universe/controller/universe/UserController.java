package com.space.ajit.universe.controller.universe;

import com.space.ajit.universe.exception.UserDetailsException;
import com.space.ajit.universe.model.universe.UserDetails;
import com.space.ajit.universe.service.UserService;
import com.space.ajit.universe.validator.UserDetailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    //@Qualifier("india")
    private UserDetailValidator userDetailValidator;

    @RequestMapping("/user")
    public String sayHello() {
        return "User API";

    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(userDetailValidator);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<UserDetails>> userDetails() {

        List<UserDetails> userDetails = userService.getUserDetails();
        return new ResponseEntity<List<UserDetails>>(userDetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDetails> findById(@PathVariable(name = "id", value = "id") Long id) {

        UserDetails userDetail = userService.findById(id);
        return new ResponseEntity<UserDetails>(userDetail, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDetails> findById(@Valid @RequestBody UserDetails userDetails, BindingResult  bindingResult) throws Throwable {


        userDetailValidator.validate(userDetails,bindingResult);
        if (bindingResult.hasErrors()) {

            Map<String,String> map = new HashMap<String,String>();
            MapBindingResult err = new MapBindingResult(map, UserDetails.class.getName());
            userDetailValidator.validate(userDetails, err);
            List<ObjectError> list = err.getAllErrors();
            for(ObjectError objErr : list){
                System.out.println(objErr.getDefaultMessage());
            }
        }
        /*Errors errors = new BeanPropertyBindingResult(userDetails, "object");
       *//* if (bindingResult.hasErrors()) {
            throw new UserDetailsException("User detail have error");
        }*//*

        errors.hasErrors();*/

        UserDetails userDetail = userService.save(userDetails);
        return new ResponseEntity<UserDetails>(userDetail, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/email/{email:.+}", method = RequestMethod.GET)
    public ResponseEntity<UserDetails> findById(@PathVariable(name = "email", value = "email") String email) {

        UserDetails userDetail = userService.findByEmail(email);
        return new ResponseEntity<UserDetails>(userDetail, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletes(@PathVariable(name = "id", value = "id") Long id) {

        userService.delete(id);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

}
