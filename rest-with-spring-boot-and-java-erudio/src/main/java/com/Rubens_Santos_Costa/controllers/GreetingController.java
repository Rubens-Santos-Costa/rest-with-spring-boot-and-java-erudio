package com.Rubens_Santos_Costa.controllers;

import com.Rubens_Santos_Costa.model.Greeting;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter  = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value= "name", defaultValue = "word") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
