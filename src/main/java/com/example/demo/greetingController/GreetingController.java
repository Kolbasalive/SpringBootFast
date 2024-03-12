package com.example.demo.greetingController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Value("${greeting-name: Mirage}")
    private String name;

    @Value("${greeting-coffee: ${greeting-name} is drinking Cafe Ganador}")
    private String coffee;

    @GetMapping("/coffee")
    public String getNameAndCoffee() {
        return coffee;
    }

    @GetMapping
    public String getName() {
        return name;
    }
}
