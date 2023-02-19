package com.dphone.userservice.service;

import java.util.List;

import com.dphone.userservice.bean.UserBean;

public interface UserService {

	
	public String addUser(UserBean userBean);
	public String deleteUser(int userId);
	public String updateUser(int userId,UserBean bean);
	public  UserBean findUserById(int userId);
	public List<UserBean> selectAll();
	public int returnUserIdByRef();
	public String login(int id);
	public String logout(int id);
	public String getRefCodeFromUser();
	public UserBean getActiveUser();
	public int getUserByRefCode(String refcode);
	public int getUserByRefCodeAddPts(String refcode);
	
}
