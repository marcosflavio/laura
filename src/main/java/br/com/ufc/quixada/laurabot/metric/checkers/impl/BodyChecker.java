package br.com.ufc.quixada.laurabot.metric.checkers.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.model.User;
import br.com.ufc.quixada.laurabot.api.services.UsersService;
import br.com.ufc.quixada.laurabot.metric.checkers.MetricChecker;

@Component
public class BodyChecker implements MetricChecker {

	@Autowired
	private UsersService userService;
	
	@Override
	public Double check(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		Double bodyValue = 0.0;
		
		if(answeredByUser(javaQuestion, javaAnswer))
			bodyValue += 0.25;
		
		if(calculateOverlappingWords(javaQuestion, javaAnswer))
			bodyValue += 0.25;
		
		if(isMoralAnswer(javaAnswer))
			bodyValue += 0.25;
		
		if(isImpersonalAnswer(javaAnswer))
			bodyValue += 0.25;
		
		return bodyValue;
	}
	
	private Boolean answeredByUser(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		Long userId = javaQuestion.getPost().getOwnerUserId();
		User questionUser = userService.findOne(userId);
		return javaAnswer.getUser().equals(questionUser);
	}
	
	private Boolean calculateOverlappingWords(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		String[] titleWords = javaQuestion.getPost().getTitle().split(" ");
		List<String> listOfTitleWords = new ArrayList<>(Arrays.asList(titleWords));

		int sizeOfTitleWords = listOfTitleWords.size();

		String[] bodyWords = javaAnswer.getBody().split(" ");
		List<String> listOfBodyWords = new ArrayList<>(Arrays.asList(bodyWords));

		int count = 0;

		for (String titleWord : listOfTitleWords) {
			for (String bodyWord : listOfBodyWords) {
				if (titleWord.equals(bodyWord))
					count++;
			}
		}

		if (count >= (sizeOfTitleWords / 2))
			return true;
		return false;
	}
	
	private Boolean isImpersonalAnswer(JavaAnswer javaAnswer) {
		String[] personalWords = { "minha mulher", "meu pai", "meu amigo", "meu vizinho", "meu professor", "meu colega", 
				"minha namorada", "meu namorado", "eu não sei", "eu acho que", "penso que", "minha", "meu"};

		List<String> listOfPersonalWords = new ArrayList<>(Arrays.asList(personalWords));

		for (String personal : listOfPersonalWords) {
			if (javaAnswer.getBody().toLowerCase().contains(personal))
				return false;
		}
		return true;
	}
	
	private Boolean isMoralAnswer(JavaAnswer javaAnswer) {
		String[] obscenesWords = { "droga", "burro", "idiota", "abestado", "animal", "jumento", "retardado", "jegue",
				"vadia", "rapariga", "viado", "baitola", "puto", "pariu", "foda", "fodido", "caralho", "merda", "bosta",
				"imbecil", "cu", "buceta", "rola", "arrombado", "vacilão", "cusao", "cuzão", "cusão", "cuzao",
				"bostinha", "merdinha", "anormal", "escroto", "cacete", "gay" };

		List<String> listOfObsceneWords = new ArrayList<>(Arrays.asList(obscenesWords));

		for (String obscene : listOfObsceneWords) {
			if (javaAnswer.getBody().toLowerCase().contains(obscene))
				return false;
		}
		return true;
	}
}
