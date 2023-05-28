package com.example.studentbook_api.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class MainController {

    @RequestMapping("/{anything}")
    public String getMainPage() {
        return "this works";
    }
}
