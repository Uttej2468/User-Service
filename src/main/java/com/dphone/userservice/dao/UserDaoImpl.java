package com.dphone.userservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl {

	@Autowired
	private UserDao userdao;
	
	public int findAllSal() {

		int id = userdao.getUserIdByRef();
 		return id;
	}
	
}
