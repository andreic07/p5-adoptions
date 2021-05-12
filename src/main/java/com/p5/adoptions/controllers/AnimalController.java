package com.p5.adoptions.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController
    {
       // Old way: @RequestMapping(method = RequestMethod.GET, value = "/hello")
       // call: /api/v1/animals/hello
        @GetMapping("/hello")

        public String greetOwner()
        {

            String hello="Hello world, from the animal shelter!";
            return hello;


        }


    }
