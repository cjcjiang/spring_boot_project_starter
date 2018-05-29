package com.jiang.springbootserverstarter.serviceInterface;

import java.util.List;

import com.jiang.springbootserverstarter.beans.UserCredit;

public interface CreditUsingSVInterface {
	
	UserCredit selectByID(Integer id);
	
	void multiAddCredit(List<Integer> idList);

}
