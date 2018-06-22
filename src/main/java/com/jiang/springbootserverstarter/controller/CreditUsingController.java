package com.jiang.springbootserverstarter.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiang.springbootserverstarter.beans.UserCredit;
import com.jiang.springbootserverstarter.serviceImpl.CreditUsingSVImpl;

/**
 * 测试transaction的接口。
 * 
 * @author Yuming Jiang
 * @since 0.0.1-SNAPSHOT
 */
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
		idList.add(3);
		idList.add(4);
		idList.add(5);
		idList.add(1);
		idList.add(2);
		creditUsingSVImpl.multiAddCredit(idList);;
    }

}
