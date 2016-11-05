package com.lancefallon.usermgmt.users.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancefallon.usermgmt.users.model.User;
import com.lancefallon.usermgmt.users.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Integer id){
		return userRepository.findById(id);
	}
	
	public Integer addUser(User user){
		return userRepository.addUser(user);
	}
	
	public Map<Integer, String> getUsersMap(){
		return userRepository.findAll().stream()
				.collect(Collectors.toMap(u->u.getId(), u->u.getUsername()));
	}
}
