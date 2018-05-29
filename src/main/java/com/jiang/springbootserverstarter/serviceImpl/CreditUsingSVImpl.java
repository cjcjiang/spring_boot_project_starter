package com.jiang.springbootserverstarter.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiang.springbootserverstarter.beans.UserCredit;
import com.jiang.springbootserverstarter.dao.UserCreditDAO;
import com.jiang.springbootserverstarter.serviceInterface.CreditUsingSVInterface;

@Service
public class CreditUsingSVImpl implements CreditUsingSVInterface {
	
	@Autowired
	private UserCreditDAO userCreditDAO;

	@Override
	public UserCredit selectByID(Integer id) {
		UserCredit userCredit = userCreditDAO.selectByID(id);
		return userCredit;
	}
	
}
