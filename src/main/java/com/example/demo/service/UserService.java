package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRep;
	
	public User save (User user) {
		return userRep.save(user);
	}

	public boolean verification(User user) {
		User u1 = userRep.findByUserNameAndPassWord(user.getUserName(), user.getPassWord());
		if (u1 == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public User findByUserName (String userName) {
		return userRep.findByUserName(userName);
	}
}
