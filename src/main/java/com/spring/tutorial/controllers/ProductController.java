package com.spring.tutorial.controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by thandomafela on 03/04/2016.
 */
@RequestMapping(path = "/api")
@RestController
public class ProductController {
    private final String IMAGE_LOCATION = "/Users/thandomafela/Desktop/kerrie.jpg";


    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<InputStreamResource> getProfilePicture() throws Exception{
        File imageFile = new File(IMAGE_LOCATION);
        if(!imageFile.exists()) {
            throw new FileNotFoundException("Image does not exist");
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<InputStreamResource>(
                new InputStreamResource(
                        new FileInputStream(imageFile)),httpHeaders, HttpStatus.OK);

    }

}
