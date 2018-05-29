package com.jiang.springbootserverstarter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	@Transactional
	public void multiAddCredit(List<Integer> idList) {
		for(Integer id : idList) {
			UserCredit userCredit = userCreditDAO.selectByID(id);
			try {
				userCredit.setCredit(userCredit.getCredit()+100);
			}catch(NullPointerException e) {
				e.printStackTrace();
			}finally {
				if(userCredit == null) {
					userCredit = new UserCredit();
					userCredit.setCredit(0);;
				}
			}
			int affectedRows = userCreditDAO.updateByID(userCredit);
			System.out.println("````````````````````````");
			System.out.println("````````````````````````");
			System.out.println("````````````````````````");
			System.out.println(affectedRows);
		}
	}
	
}
