package com.subham.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subham.quiz.entiry.Question;
import com.subham.quiz.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionserv;
	
	@GetMapping("all")
	public List<Question> getAll() {
		return questionserv.getAllQuestions();
	}
	
	@GetMapping("{tech}")
	public ResponseEntity<List<Question>> getByTech(@PathVariable("tech") String tech){
		try {
			return ResponseEntity.ok(questionserv.getQuestionByTech(tech));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("")
	public ResponseEntity<Question> submitQuestion(@RequestBody Question que) {
		try {
			return ResponseEntity.ok(questionserv.newQuestion(que));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> removeQuestion(@PathVariable("id") int id){
		try {
			if(questionserv.removeQuestion(id)) {
				return ResponseEntity.ok("SUCCESSFULLY DELETED");
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable("id") int id, @RequestBody Question que){
		try {
			return ResponseEntity.ok(questionserv.updateQuestion(id, que));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
