package com.subham.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subham.quiz.entiry.Question;
import com.subham.quiz.entiry.QuestionWrapper;
import com.subham.quiz.entiry.Quiz;
import com.subham.quiz.repository.QuestionRepository;
import com.subham.quiz.repository.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo quizrepo;
	
	@Autowired
	QuestionRepository questionrepo;
	
	public Quiz createQuiz(String catagory, int num, String name){
		List<Question> list = questionrepo.findByTechnology(catagory);
		List<Question> ans= new ArrayList<>();
		Random rand = new Random();
		int numberOfElements = num;
		
		for (int i = 0; i < numberOfElements; i++) {
	        int randomIndex = rand.nextInt(list.size());
	        Question element = list.get(randomIndex);
	        ans.add(element);
	        list.remove(randomIndex);
	    }
		
		Quiz quiz= new Quiz();
		quiz.setName(name);
		quiz.setQuestions(ans);
		
		return quizrepo.save(quiz);
	}
	
	public Quiz getQuiz(String name) {
		return quizrepo.findByName(name);
	}
	
	public List<QuestionWrapper> getQuestions(String name){
		Quiz quiz = quizrepo.findByName(name);
		
		List<Question> questions = quiz.getQuestions();
		List<QuestionWrapper> questionsForClient = new ArrayList<>();
		
		for(Question q: questions) {
			QuestionWrapper w = new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForClient.add(w);
		}
		return questionsForClient;
	}
}
