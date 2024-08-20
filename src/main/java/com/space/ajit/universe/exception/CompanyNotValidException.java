package com.space.ajit.universe.exception;

import com.space.ajit.universe.model.company.Company;

public class CompanyNotValidException extends Exception {

    public CompanyNotValidException() {
        super();
    }

    public CompanyNotValidException(String message) {
        super(message);
    }

}
