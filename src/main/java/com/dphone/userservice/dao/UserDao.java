package com.dphone.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dphone.userservice.bean.UserBean;
import com.dphone.userservice.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer> {

	@Query("SELECT e.userId FROM UserEntity e WHERE status='active'")
	public int getUserIdByRef();
	
	@Query("SELECT e.refcode FROM UserEntity e WHERE status='active'")
	public String getRefCodeFromUser();
//	@Query("SELECT e FROM UserEntity e WHERE e.ref= :refcode")
//	public UserEntity getUserByRefCode(@Param("refcode") int refcode);
//	
}
