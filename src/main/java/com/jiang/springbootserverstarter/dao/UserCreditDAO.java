package com.jiang.springbootserverstarter.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jiang.springbootserverstarter.beans.UserCredit;

@Mapper
public interface UserCreditDAO {
	
	UserCredit selectByID(Integer id);
	
	int updateByID(UserCredit userCredit);

}
