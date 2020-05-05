package com.space.ajit.universe.validator;

import com.space.ajit.universe.model.universe.UserDetails;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserDetailValidator implements Validator {
    private String ID_REQUIRED = "id.required";

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDetails.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id",ID_REQUIRED);

        UserDetails userDetails = (UserDetails) object;
        if(userDetails.getId()<1) {
            errors.rejectValue("id", "negativeValue", new Object[]{"'id'"}, "id can't be negative");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");

    }
}
