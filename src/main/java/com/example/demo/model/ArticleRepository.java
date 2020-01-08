package com.example.demo.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {
 
	Article findById(long id);
	
	Long deleteById(long id);

	@Query(value = "SELECT new map(a.id as id, a.title as title, a.date as date, a.state as state, a.content as content) FROM User u, Article a WHERE u.id = a.user_id and a.user_id = :userId")
	List<Map<String, Object>> getArticleListByUserId(@Param("userId") long userId);

	List<Article> findAllByState(String state);
}
