package br.com.ufc.quixada.laurabot.api.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.model.Question;
import br.com.ufc.quixada.laurabot.api.services.JavaQuestionService;
import br.com.ufc.quixada.laurabot.api.services.QuestionService;

@Component
public class JavaQuestionFactory {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private JavaQuestionService javaQuestionService;

	public void create() {
		List<Question> javaQuestions = questionService.findByTag("<java>");

		javaQuestions.forEach(question -> {
			JavaQuestion javaQuestion = new JavaQuestion();
			javaQuestion.setPostId(question.getPostId());
			javaQuestion.setTitle(question.getTitle());
			javaQuestionService.save(javaQuestion);
		});
	}
}
