package com.jiang.springbootserverstarter.serviceInterface;

import java.util.List;

import com.jiang.springbootserverstarter.beans.UserCredit;

/**
 * 包含与user_credit表操作相关的业务逻辑的服务的接口。
 * 
 * @author Yuming Jiang
 * @since 0.0.1-SNAPSHOT
 */
public interface CreditUsingSVInterface {
	
	UserCredit selectByID(Integer id);
	
	void multiAddCredit(List<Integer> idList);

}
