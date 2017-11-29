package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.repositories.IJavaAnswerRepository;

@Service
public class JavaAnswerService {

	@Autowired
	private IJavaAnswerRepository repository;
	
	public List<JavaAnswer> findAll() {
		return repository.findAll();
	}
	
	public void save(JavaAnswer javaAnswer) {
		repository.save(javaAnswer);
	}
	
	public JavaAnswer findByPostId(Long postId) {
		return repository.findByPostId(postId);
	}
}
