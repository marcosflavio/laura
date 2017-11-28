package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.Answer;
import br.com.ufc.quixada.laurabot.api.repositories.IAnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private IAnswerRepository iAnswerRepository;

	public void save(Answer answer) {
		iAnswerRepository.save(answer);
	}
	
	public List<Answer> findByQuestionId(Long questionId) {
		return iAnswerRepository.findByQuestionId(questionId);
	}
}
