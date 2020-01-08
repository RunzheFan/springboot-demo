package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.model.Article;
import com.example.demo.model.User;
import com.example.demo.service.ArticleService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(value = "/personal")
public class PersonalController {

	@Resource
	ArticleService articleService;
	@Resource
	UserService userService;
	
	@GetMapping(value = "/")
	public String personalIndex(Model model, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loginName");
		User user = userService.findByUserName(userName);
		model.addAttribute("user", user);
		return ("web/personal/index");
	}
	
	@GetMapping(value = "/initArticle")
	public String newArticle(Model model, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loginName");
		User user = userService.findByUserName(userName);
		model.addAttribute("user", user);
		return ("web/personal/initArticle");
	}

	@ApiOperation(value="getArticleList", notes="getArticleList")
	@GetMapping(value = "/articles")
	public String list(Model model, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loginName");
		User user = userService.findByUserName(userName);
		model.addAttribute("user", user);
		List<Map<String, Object>> article = articleService.getArticleListByUserId(user.getId());
		model.addAttribute("article", article);
		return "web/personal/articleList";
	}

	@ApiOperation(value="createNewArticle", notes="createNewArticle")
    @PostMapping(value = "/articles")
	public String save(Article article, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loginName");
		User user = userService.findByUserName(userName);
		article.setUser_id(user.getId());;
		Date date = new Date();
		article.setDate(date);
		articleService.save(article);
		return "redirect:/personal/articles";
	}
	
	@ApiOperation(value="getArticleByID", notes="getArticleByID")
    @GetMapping(value = "/articles/{id}")
	public String edit(@PathVariable("id") long id, Model model, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loginName");
		User user = userService.findByUserName(userName);
		model.addAttribute("user", user);
		Article article = articleService.findById(id);
		model.addAttribute("article", article);
		return "web/personal/articleUpdate";
	}
	
	@ApiOperation(value="deleteArticleByID", notes="deleteArticleByID")
    @DeleteMapping(value = "/articles/{id}")
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id") long id) {
		articleService.delete(id);
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", true);
		return resultMap;
	}
	
	@ApiOperation(value="updateArticleByID", notes="updateArticleByID")
	@PatchMapping(value = "/articles/{id}")
	public String update(@RequestBody Article article) {
		articleService.save(article);
		return "redirect:/personal/articles";
	}

}
