package com.example.studentbook_api.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    //TODO: add depedency injection to access the database

    @RequestMapping(value = "/{studentSurname}", method = RequestMethod.GET)
    public String getStudent(@PathVariable String studentSurname) {
        return "TEST STUDENT";
    }
}
