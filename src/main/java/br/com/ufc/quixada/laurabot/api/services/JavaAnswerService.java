package br.com.ufc.quixada.laurabot.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.repositories.IJavaAnswerRepository;

@Service
public class JavaAnswerService {

	@Autowired
	private IJavaAnswerRepository repository;
	
	public void save(JavaAnswer javaAnswer) {
		repository.save(javaAnswer);
	}
}
