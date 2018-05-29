package com.jiang.springbootserverstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiang.springbootserverstarter.beans.UserCredit;
import com.jiang.springbootserverstarter.serviceImpl.CreditUsingSVImpl;

@RestController
public class CreditUsingController {
	
	@Autowired
	private CreditUsingSVImpl creditUsingSVImpl;
	
	@RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/test")
    public UserCredit test() {
		UserCredit userCredit = creditUsingSVImpl.selectByID(1);
        return userCredit;
    }

}
