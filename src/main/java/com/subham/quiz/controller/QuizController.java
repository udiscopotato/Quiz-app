package com.subham.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.subham.quiz.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizserv;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String catagory,@RequestParam int num,@RequestParam String name){
		return ResponseEntity.ok("Working Fine");
	}
	
}
