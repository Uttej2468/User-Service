package com.dphone.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dphone.userservice.bean.UserBean;
import com.dphone.userservice.dao.UserDao;
import com.dphone.userservice.entity.UserEntity;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserDao dao;

	
	public String addUser(UserBean userBean) {
		// TODO Auto-generated method stub
		
		UserEntity entity =new UserEntity();
		BeanUtils.copyProperties(userBean, entity);
		
		dao.save(entity);
		return "Added";
	}


	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		Optional<UserEntity> userEntity = dao.findById(userId);

		UserEntity userEntity2 = userEntity.get();
		UserBean bean=new UserBean();

		BeanUtils.copyProperties(userEntity2, bean);
		
		dao.delete(userEntity2);
		
		return "deleted:"+userEntity2;
	}


	@Override
	public String updateUser(int userId, UserBean bean) {
		// TODO Auto-generated method stub
		Optional<UserEntity> userEntity = dao.findById(userId);
		UserEntity user = userEntity.get();
		
		
		user.setUserId(bean.getUserId());
		user.setLastName(bean.getLastName());
		user.setAddress(bean.getAddress());
		user.setUserName(bean.getUserName());
		user.setPassword(bean.getPassword());
		
		dao.save(user);
		return "updatedById :" + user;
	}


	@Override
	public String findUserById(int userId) {
		// TODO Auto-generated method stub
		Optional<UserEntity> userEntity = dao.findById(userId);

		UserEntity userEntity2 = userEntity.get();

		UserBean bean=new UserBean();
		BeanUtils.copyProperties(userEntity2, bean);

		return "Found"+userEntity2;
	}


	@Override
	public List<UserBean> selectAll() {
		// TODO Auto-generated method stub
		
		ArrayList<UserBean> userList = new ArrayList<UserBean>();
		Iterable<UserEntity> it = dao.findAll();

		it.forEach(x -> {

			UserBean bean = new UserBean();
			BeanUtils.copyProperties(x, bean);
			userList.add(bean);

		});

		return userList;
	}

	@Override
	public int returnUserIdByRef() {
		
		return dao.getUserIdByRef();
	}

	
	@Override
	public String login(int id) {
		UserEntity found=dao.findById(id).get();
		found.setStatus("acitve");
		return "logged In";
	}
	
	@Override
	public String logout(int id) {
		UserEntity found=dao.findById(id).get();
		found.setStatus("inactive");
		return "logged Out";
	}


	@Override
	public String getRefCodeFromUser() {
		
		return dao.getRefCodeFromUser();
	}


//	@Override
//	public UserBean getUserByRefCode(int refcode) {
//
//		UserEntity user = dao.getUserByRefCode(refcode);
//		
//		UserBean bean = new UserBean();
//		
//		BeanUtils.copyProperties(user, bean);
//		
//		return bean;
//	}
	
	
}
