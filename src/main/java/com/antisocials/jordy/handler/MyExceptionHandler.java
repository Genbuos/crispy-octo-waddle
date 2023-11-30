package com.antisocials.jordy.handler;

import com.antisocials.jordy.dto.Detail;
import com.antisocials.jordy.exceptions.CategoryIdNotFoundException;
import com.antisocials.jordy.exceptions.NoContentException;
import com.antisocials.jordy.exceptions.ProductIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoryIdNotFoundException.class)
    public ResponseEntity<?> handleCategoryNotFound(CategoryIdNotFoundException categoryIdNotFoundException){
        Detail detail =new Detail(HttpStatus.NOT_FOUND.value(), categoryIdNotFoundException.getMessage());
        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<?> handleProductIdNotFound(ProductIdNotFoundException categoryIdNotFoundException){
        Detail detail =new Detail(HttpStatus.NOT_FOUND.value(), categoryIdNotFoundException.getMessage());
        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<?> handleNoContent(NoContentException categoryIdNotFoundException){
        Detail detail =new Detail(HttpStatus.NO_CONTENT.value(), categoryIdNotFoundException.getMessage());
        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }
}
