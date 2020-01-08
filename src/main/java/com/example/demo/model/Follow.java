package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Follow implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Long user_id;
	@Column(nullable = false)
	private Long follow_id;
	@Column(nullable = false)
	private Date date;
	@Column(nullable = false)
	private Long group_id;
	
	public Follow() {
		super();
	}

	public Follow(Long id, Long user_id, Long follow_id, Date date, Long group) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.follow_id = follow_id;
		this.date = date;
		this.group_id = group_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getFollow_id() {
		return follow_id;
	}

	public void setFollow_id(Long follow_id) {
		this.follow_id = follow_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}
	
	
	
}
