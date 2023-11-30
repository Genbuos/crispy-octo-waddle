package com.antisocials.jordy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductIdNotFoundException extends NoSuchElementException {
    public ProductIdNotFoundException() {
    }

    public ProductIdNotFoundException(String s) {
        super(s);
    }
}
