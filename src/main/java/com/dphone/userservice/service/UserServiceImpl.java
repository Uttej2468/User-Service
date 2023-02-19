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

//import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserDao dao;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;

	//Adding the New User
	public String addUser(UserBean userBean) {
		// TODO Auto-generated method stub

		UserEntity entity =new UserEntity();
		BeanUtils.copyProperties(userBean, entity);
		
//		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		entity.setRoles("ROLE_USER");
		dao.save(entity);
		return "Added";
	}

	//Show all existing Users
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
	
	//Find the User By UserID
	@Override
	public UserBean findUserById(int userId) {
		// TODO Auto-generated method stub
		Optional<UserEntity> userEntity = dao.findById(userId);

		UserEntity userEntity2 = userEntity.get();

		UserBean bean=new UserBean();
		BeanUtils.copyProperties(userEntity2, bean);

		return bean;
	}
	
	//Update the User by UserID
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
		
		
	//Delete the User by UserID
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


	//Find the UserID of the User whose session is active
	@Override
	public int returnUserIdByRef() {
		
		return dao.getUserIdByRef();
	}

	//Find the ReferralCode from the User whose session is active
	@Override
	public String getRefCodeFromUser() {
		
		return dao.getRefCodeFromUser();
	}
		
	//Find the UserEntity of the User whose session is active
	@Override
	public UserBean getActiveUser() {

		UserBean bean =new UserBean();
		UserEntity entity = dao.getActiveUser();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}	
	
	//Find UserId from the User whose User(ReferralCode) matches the given ReferralCode
	@Override
	public int getUserByRefCode(String refcode) {
		int id= dao.getUserByRefCode(refcode);
		UserEntity entity = dao.findById(id).get();
		dao.save(entity);
		return id;
	}
	
	//Find UserId from the User whose User(ReferralCode) matches the given ReferralCode and adding 10000 points
	@Override
	public int getUserByRefCodeAddPts(String refcode) {
		int id= dao.getUserByRefCode(refcode);
		UserEntity entity = dao.findById(id).get();
		entity.setReferralPoints(entity.getReferralPoints()+1000);
		dao.save(entity);
		return id;
	}
	
	//
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

	
	
}
