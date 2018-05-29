package com.jiang.springbootserverstarter.serviceInterface;

import com.jiang.springbootserverstarter.beans.UserCredit;

public interface CreditUsingSVInterface {
	
	UserCredit selectByID(Integer id);

}
