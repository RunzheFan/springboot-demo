package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Article;
import com.example.demo.model.User;
import com.example.demo.service.ArticleService;
import com.example.demo.service.UserService;

@Controller
public class IndexController {
	
	@Resource
	UserService userService;
	@Resource
	ArticleService articleService;
	
	@RequestMapping("/")
	public String index1(Locale locale, Model model) {
		return "redirect:index";
	}
	
	@RequestMapping("/index")
	public String index(Locale locale, Model model, HttpServletRequest request) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
		String formattedDate = dateFormat.format(date);
		model.addAttribute("currentTime", formattedDate);
		String userName = (String) request.getSession().getAttribute("loginName");
		User user = userService.findByUserName(userName);
		model.addAttribute("user", user);
		List<Article> article = articleService.getArticleListByState("1");
		model.addAttribute("article", article);
		return "index";
	}

}
