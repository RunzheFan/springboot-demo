package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String passWord;
	@Column(nullable = false)
	private Long authority;
	
	public Administrator() {
		super();
	}

	public Administrator(Long id, String userName, String passWord,
			Long authority) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Long getAuthority() {
		return authority;
	}

	public void setAuthority(Long authority) {
		this.authority = authority;
	}
	
	
	
}
