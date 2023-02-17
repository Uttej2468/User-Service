package com.dphone.userservice.service;

import java.util.List;

import com.dphone.userservice.bean.UserBean;

public interface UserService {

	
	public String addUser(UserBean userBean);
	public String deleteUser(int userId);
	public String updateUser(int userId,UserBean bean);
	public  String findUserById(int userId);
	public List<UserBean> selectAll();
	public int returnUserIdByRef();
	public String login(int id);
	public String logout(int id);
//	public UserBean getUserByRefCode(int refcode);
	public String getRefCodeFromUser();
}
