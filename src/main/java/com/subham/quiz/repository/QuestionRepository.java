package com.subham.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subham.quiz.entiry.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	public List<Question> findByTechnology(String technology);

}
