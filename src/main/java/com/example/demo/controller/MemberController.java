package com.example.demo.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class MemberController {
	
	@Resource
	UserService userService;
	
	@RequestMapping("/member/register")
	public String register() {
		return "member/register";
	}
	
	@RequestMapping("/member/saveMember")
	public String save(User user) {
		Date date = new Date();
		user.setRegTime(date);
		userService.save(user);
		return "redirect:/index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("/verifyUser")
	public String verify(User user, HttpServletRequest request) { 
		boolean flag = false;
		flag = userService.verification(user);
		if (flag) {
			request.getSession().setAttribute("loginName", user.getUserName());
			return "redirect:/index";
		} else {
			return "member/login";
		}
	}
	
	@RequestMapping("/loginout")
    public String loginOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}
