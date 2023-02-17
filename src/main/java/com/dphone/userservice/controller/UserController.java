package com.dphone.userservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.dphone.userservice.bean.UserBean;
import com.dphone.userservice.service.UserServiceImpl;


@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/check")
	public String check()
	{
		return "running succesfull";
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody UserBean bean){
		int temp=bean.getUserId();
		System.out.println(temp);
		bean.setRefcode(bean.getUserName()+"@"+ temp);
		String message = userServiceImpl.addUser(bean);
		return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/selectalluser")
	public ResponseEntity<?> selectAll() {

		List<UserBean> message = userServiceImpl.selectAll();

		return new ResponseEntity<>(message, HttpStatus.OK);

	}
	
	@GetMapping("finduserbyid/{userId}")
	public ResponseEntity<?> findCustomerById(@PathVariable int userId) {

		try {
			String message = userServiceImpl.findUserById(userId);
			return new ResponseEntity<>(message, HttpStatus.OK);

		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping("updateuser/{userId}")
	public ResponseEntity<?> updateCustomer(@PathVariable int userId, @RequestBody UserBean bean) {

		try {
			String message = userServiceImpl.updateUser(userId, bean);
			return new ResponseEntity<>(message, HttpStatus.OK);

		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<>("Customer with the given ID is not Found", HttpStatus.NOT_FOUND);
		}

	}
	
	
	@DeleteMapping("deleteUser/{userId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int userId) {

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
	
	@GetMapping("finduserByRef")
	public ResponseEntity<Integer> returnUserIdByRef(){
		
		int id=userServiceImpl.returnUserIdByRef();
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
	
	
	//working
	@GetMapping("getRefCodeFromUser")
	public ResponseEntity<String> getRefCodeFromUser() {
		String refcode = userServiceImpl.getRefCodeFromUser();
		return new ResponseEntity<String>(refcode,HttpStatus.OK);
	}
	
	
	//just for now before spring security
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
	
	
	
	
//	@GetMapping("/getUserByRefCode/{refcode}")
//	public ResponseEntity<UserBean> getUserByRefCode(@PathVariable int refcode) {
//		return new ResponseEntity<UserBean>(userServiceImpl.getUserByRefCode(refcode),HttpStatus.OK);
//	}

}
