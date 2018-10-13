package com.beezen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/mobile")
public class AppController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "index";
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String handleNotFound() {
        return "default";
    }}
