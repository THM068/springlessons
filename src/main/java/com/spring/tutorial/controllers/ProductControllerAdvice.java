package com.spring.tutorial.controllers;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.Optional;

/**
 * Created by thandomafela on 24/04/2016.
 */
@ControllerAdvice
@ResponseBody
@RequestMapping(produces = "application/vnd.error")
public class ProductControllerAdvice {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(FileNotFoundException.class)
    public VndErrors fileNotFoundException(FileNotFoundException ex) {
        return this.error(ex, ex.getLocalizedMessage());
    }

    private <E extends Exception> VndErrors error(E e, String logref) {
        String msg = Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
        return new VndErrors(logref, msg);
    }
}
