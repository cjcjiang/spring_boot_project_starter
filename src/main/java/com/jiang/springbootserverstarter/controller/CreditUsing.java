package com.jiang.springbootserverstarter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditUsing {
	
	@RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

}
