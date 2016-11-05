package com.lancefallon.usermgmt.users.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lancefallon.usermgmt.users.model.User;
import com.lancefallon.usermgmt.users.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAllUsers(){
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public ResponseEntity<User> findAllUsers(@PathVariable Integer userId){
		return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/map", method=RequestMethod.GET)
	public ResponseEntity<Map<Integer, String>> generateUserMap(){
		return new ResponseEntity<>(userService.getUsersMap(), HttpStatus.OK);
	}
}
