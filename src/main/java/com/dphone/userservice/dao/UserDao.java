package com.dphone.userservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dphone.userservice.entity.UserEntity;

// < User Dao >

public interface UserDao extends JpaRepository<UserEntity, Integer> {

	@Query("SELECT e.userId FROM UserEntity e WHERE status='active'")
	public int getUserIdByRef();
	
	@Query("SELECT e.refcode FROM UserEntity e WHERE status='active'")
	public String getRefCodeFromUser();
	@Query("SELECT e FROM UserEntity e WHERE status='active'")
	public UserEntity getActiveUser();
	
	@Query("SELECT e.userId FROM UserEntity e WHERE e.refcode= :refcode")
	public Integer getUserByRefCode(@Param("refcode") String refcode);
	
	//For Spring Security
	@Query("SELECT u FROM UserEntity u WHERE u.userName= :username")
	Optional<UserEntity> findByName(@Param("username") String userName);
	
	
	
	
	@Query("SELECT CASE when count(*)>0 then true else false end from UserEntity u where u.userName= :username")
	boolean findByUser(@Param("username") String username);

	
	@Query("SELECT CASE when count(*)>0 then true else false end from UserEntity u where u.mobile = :mobile")
	public boolean findByMobile(@Param("mobile") String mobile);
	
	
}
