package com.subham.quiz.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.subham.quiz.entiry.Quiz;


public interface QuizRepo extends JpaRepository<Quiz, Integer> {

	public Quiz findByName(String name);
	
}
