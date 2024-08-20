package com.space.ajit.universe.validator;

import com.space.ajit.universe.model.company.Company;
import com.space.ajit.universe.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CompanyValidator implements Validator {

    @Autowired
    private CompanyRepository companyRepository;
    private int id;

    @Override
    public boolean supports(Class<?> clazz) {
        return Company.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        int id = 0;
        Optional<Company> company =companyRepository.findById(id);
        Company companys = (Company) target;
        int ids =  companys.getId();

        /*if(company.getId()<0) {
            errors.rejectValue("id", "id can't be negative");
        }*/

        errors.rejectValue("id", "id already exist");

    }
}
