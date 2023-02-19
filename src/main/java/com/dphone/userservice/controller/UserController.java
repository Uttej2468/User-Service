package com.dphone.userservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dphone.userservice.bean.UserBean;
import com.dphone.userservice.service.UserServiceImpl;

// < User Controller >

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	//Adding the New User
	@PostMapping("/adduser")
	public ResponseEntity<?> addUser(@RequestBody UserBean bean){
		
	
		String message = userServiceImpl.addUser(bean);
		return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
	
	//Show all existing Users
	@GetMapping("/selectalluser")
	public ResponseEntity<?> selectAll() {

		List<UserBean> message = userServiceImpl.selectAll();

		return new ResponseEntity<>(message, HttpStatus.OK);

	}
	
	//Find the User By UserID
	@GetMapping("finduserbyid/{userId}")
	public ResponseEntity<?> findUserById(@PathVariable int userId) {

		try {
			UserBean bean = userServiceImpl.findUserById(userId);
			return new ResponseEntity<>(bean, HttpStatus.OK);

		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	//Update the User by UserID
	@PutMapping("updateuser/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody UserBean bean) {

		try {
			String message = userServiceImpl.updateUser(userId, bean);
			return new ResponseEntity<>(message, HttpStatus.OK);

		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<>("Customer with the given ID is not Found", HttpStatus.NOT_FOUND);
		}

	}
	
	//Delete the User by UserID
	@DeleteMapping("deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable int userId) {

		try {
			String message = userServiceImpl.deleteUser(userId);
			return new ResponseEntity<>(message, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			System.err.println(e);
			return new ResponseEntity<>("Customer with the given ID is not Found", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<>("No elements present", HttpStatus.NOT_FOUND);
		}
	}
	
		
	//Find the UserID of the User whose session is active
	@GetMapping("finduserByRef")
	public ResponseEntity<Integer> returnUserIdByRef(){
		
		int id=userServiceImpl.returnUserIdByRef();
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
	

	//Find the ReferralCode from the User whose session is active
	@GetMapping("getRefCodeFromUser")
	public ResponseEntity<String> getRefCodeFromUser() {
		String refcode = userServiceImpl.getRefCodeFromUser();
		return new ResponseEntity<String>(refcode,HttpStatus.OK);
	}
	
	//Find the UserEntity of the User whose session is active
	// < Used for BuyingDetails Service >
	@GetMapping("getActiveUser")
	public ResponseEntity<UserBean> getActiveUser(){
		
		UserBean bean = userServiceImpl.getActiveUser();
		return new ResponseEntity<UserBean>(bean,HttpStatus.OK);
	}
	
	//Find UserId from the User whose User(ReferralCode) matches the given ReferralCode
	// < Used for Referral Service >
	@GetMapping("/getUserByRefCode/{refcode}")
	public ResponseEntity<Integer> getUserByRefCode(@PathVariable String refcode) {
		return new ResponseEntity<Integer>(userServiceImpl.getUserByRefCode(refcode),HttpStatus.OK);
	}
	
	//Find UserId from the User whose User(ReferralCode) matches the given ReferralCode and adding 1000 points
	// < Used for BuyingDetails Service >
	@GetMapping("/getUserByRefCodeAddPts/{refcode}")
	public ResponseEntity<Integer> getUserByRefCodeAddPts(@PathVariable String refcode) {
		return new ResponseEntity<Integer>(userServiceImpl.getUserByRefCodeAddPts(refcode),HttpStatus.OK);
	}
	
	//Just for now before spring security
	@GetMapping("login/{id}")
		public ResponseEntity<String> login(@PathVariable int id) {
			String msg=userServiceImpl.login(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		
		@GetMapping("logout/{id}")
		public ResponseEntity<String> logout(@PathVariable int id){
			String msg=userServiceImpl.logout(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}	


}
