package com.jiang.springbootserverstarter.controller;

import java.util.ArrayList;

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
	
	@RequestMapping("/transaction")
    public void testTransaction() {
		ArrayList<Integer> idList = new ArrayList<>();
		idList.add(1);
		idList.add(3);
		creditUsingSVImpl.multiAddCredit(idList);;
    }

}
