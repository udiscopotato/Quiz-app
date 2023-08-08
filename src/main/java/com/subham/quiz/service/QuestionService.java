package com.subham.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subham.quiz.entiry.Question;
import com.subham.quiz.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionrepo;
	
	public List<Question> getAllQuestions() {
		List<Question> list = questionrepo.findAll();
		return list;
	}
	
	public List<Question> getQuestionByTech(String tech){
		List<Question> list = questionrepo.findByTechnology(tech);
		return list;
	}
	
	public Question newQuestion(Question que) {
		return questionrepo.save(que);
	}
	
	public boolean removeQuestion(int id) {
		List<Question> list = questionrepo.findAll();
		Question que = null;
		for(Question q:list) {
			if(q.getId() == id) {
				que=q;
			}
		}
		if(que!=null) {
			questionrepo.delete(que);
			return true;
		}
		return false;
	}
	
	public Question updateQuestion(int id, Question que) {
		if(que.getId()==id) {
			questionrepo.save(que);
			return que;
		}
		que.setId(id);
		questionrepo.save(que);
		return que;
	}
	
}
