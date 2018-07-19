package com.jiang.spring_boot_server_starter.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiang.spring_boot_server_starter.beans.UserCredit;
import com.jiang.spring_boot_server_starter.beans.helper.UnknownUserException;
import com.jiang.spring_boot_server_starter.dao.UserCreditDAO;

/**
 * 此服务实现类提供所有与user_credit表操作相关的业务逻辑。
 * 
 * @author Yuming Jiang
 * @since 0.0.1-SNAPSHOT
 */
@Service
public class CreditUsingService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserCreditDAO userCreditDAO;

	public UserCredit selectByID(Integer id) {
		UserCredit userCredit = userCreditDAO.selectByID(id);
		return userCredit;
	}
	
	@Transactional(noRollbackForClassName= {"UnknownUserException"})
	public void multiAddCredit(List<Integer> idList) {
		
		ArrayList<Integer> unknownUserIDList = new ArrayList<>();
		
		for(Integer id : idList) {
			UserCredit userCredit = userCreditDAO.selectByID(id);
			
			try {
				userCredit.setCredit(userCredit.getCredit()+100);
			}catch(NullPointerException e) {
				unknownUserIDList.add(id);
				logger.error("The user with this id: " + id + ", does not exist.");
				continue;
			}
			
			if(userCredit != null) {
				int affectedRows = userCreditDAO.updateByID(userCredit);
				if(affectedRows == 0) {
					throw new RuntimeException("Update fails.");
				}
			}
		}
		
		if(unknownUserIDList.size() != 0) {
			String unknownUserErrorMessage = "Unkown users with id: ";
			for(Integer id : unknownUserIDList) {
				unknownUserErrorMessage = unknownUserErrorMessage + id + ";";
			}
			throw new UnknownUserException(unknownUserErrorMessage);
		}
		
	}
	
}
