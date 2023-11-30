package com.antisocials.jordy.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryIdNotFoundException extends NoSuchElementException {
    public CategoryIdNotFoundException() {
    }

    public CategoryIdNotFoundException(String message) {
        super(message);
    }


}
