package com.jiang.spring_boot_server_starter.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jiang.spring_boot_server_starter.beans.UserCredit;

/**
 * 所有操作表user_credit的sql方法的接口。
 * 
 * @author Yuming Jiang
 * @since 0.0.1-SNAPSHOT
 */
@Mapper
public interface UserCreditDAO {
	
	UserCredit selectByID(Integer id);
	
	int updateByID(UserCredit userCredit);

}
