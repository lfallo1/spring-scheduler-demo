package com.lancefallon.usermgmt.users.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.lancefallon.usermgmt.users.model.User;

@Service
public class UserRepository {
	
	private List<User> users = new ArrayList<>();
	
	public UserRepository(){
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(Integer id){
		try{
			return users.stream().filter(u->u.getId().equals(id)).findFirst().get();
		} catch(NoSuchElementException e){
			return null;
		}
	}
	
	public Integer addUser(User user){
		Integer newId = nextId();
		user.setId(newId);
		users.add(user);
		return newId;
	}
	
	private Integer nextId(){
		users.sort((u1,u2)->-u1.getId().compareTo(u2.getId()));
		return users.size() > 0 ? users.get(0).getId() + 1 : 1;
	}
	
}
