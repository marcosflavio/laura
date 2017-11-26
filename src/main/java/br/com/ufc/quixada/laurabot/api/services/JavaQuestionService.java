package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.repositories.IJavaQuestionRepository;

@Service
public class JavaQuestionService {

	@Autowired
	private IJavaQuestionRepository iJavaQuestionRepository;
	
	public void save(JavaQuestion javaQuestion) {
		iJavaQuestionRepository.save(javaQuestion);
	}
	
	public List<JavaQuestion> findAll() {
		return iJavaQuestionRepository.findAll();
	}
}
