package br.com.ufc.quixada.laurabot.api.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.Answer;
import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.services.JavaAnswerService;

@Component
public class JavaAnswerFactory {
	
	@Autowired
	private JavaAnswerService javaAnswerService;
	
	public void create(Answer answer, JavaQuestion javaQuestion) {
		JavaAnswer javaAnswer = new JavaAnswer();
		javaAnswer.setJavaQuestion(javaQuestion);
		javaAnswer.setBody(answer.getBody());
		javaAnswer.setPost(answer.getPost());
		javaAnswer.setUser(answer.getUser());
		javaAnswer.setCreationDate(answer.getCreationDate());
		javaAnswer.setFavoriteCount(answer.getFavoriteCount());
		javaAnswer.setScore(answer.getScore());
		javaAnswer.setTags(answer.getTags());
		javaAnswerService.save(javaAnswer);
	}
	
}
