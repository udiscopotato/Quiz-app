package com.subham.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.subham.quiz.entiry.QuestionWrapper;
import com.subham.quiz.entiry.Quiz;
import com.subham.quiz.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizserv;
	
	@PostMapping("create")
	public ResponseEntity<Quiz> createQuiz(@RequestParam String catagory,@RequestParam int num,@RequestParam String name){
		return ResponseEntity.ok(quizserv.createQuiz(catagory, num, name));		
	}
	
	@GetMapping("get/{name}")
	public ResponseEntity<Quiz> getQuizByName(@PathVariable("name") String name){
		return ResponseEntity.ok(quizserv.getQuiz(name));
	}
	
	@GetMapping("getQuestion/{name}")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsByName(@PathVariable("name") String name){
		return ResponseEntity.ok(quizserv.getQuestions(name));
	}
}
