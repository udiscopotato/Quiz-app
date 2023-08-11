package com.subham.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.subham.quiz.entiry.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	public List<Question> findByTechnology(String technology);
	
//	@Query(value = "SELECT * FROM question q WHERE q.technology=:technology ORDER BY rand() LIMIT :number")
//	public List<Question> findRandomQuestionsByTechnology(String technology,int number);
}
