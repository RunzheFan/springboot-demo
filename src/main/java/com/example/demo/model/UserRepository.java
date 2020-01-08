package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	 User findByUserName(String userName);
	 
	 User findByUserNameAndPassWord(String userName, String passWord);
}
