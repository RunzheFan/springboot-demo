package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Article;
import com.example.demo.model.ArticleRepository;
import com.example.demo.util.PageUtil;

@Service
public class ArticleService {
	
	@Autowired
	ArticleRepository articleRep;
	
	public Article save (Article article) {
		return articleRep.save(article);
	}
	public Article findById (long id) {
		return articleRep.findById(id);
	}
	public void delete (long id) {
		articleRep.deleteById(id);
	}
	public List<Article> getArticleList() {
		return articleRep.findAll();
	}
	public List<Map<String, Object>> getArticleListByUserId(long userId) {
		return articleRep.getArticleListByUserId(userId);
	}
	public List<Article> getArticleListByState(String state) {
		return articleRep.findAllByState(state);
	}
	public Page<Article> findArticleNoCriteria(Integer page,Integer size) {
		Pageable pageable = PageUtil.getPageRequest(page, size, null);
        return articleRep.findAll(pageable);
	}
}
