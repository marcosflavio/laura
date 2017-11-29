package br.com.ufc.quixada.laurabot.metric.checkers.impl;

import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.model.User;
import br.com.ufc.quixada.laurabot.metric.checkers.MetricChecker;

@Component
public class AnswersCountChecker implements MetricChecker {

	private static int MIN_COUNT = 1;

	private static int MEDIUM_COUNT = 5;

	private static int AVG_COUNT = 10;

	private static int SUB_MAX_COUNT = 15;

	private static int MAX_COUNT = 20;

	@Override
	public Double check(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		Double count = 0.0;

		User user = javaAnswer.getUser();

		int size = user.getJavaAnswers().size();

		if (size <= MIN_COUNT)
			count = 0.0;

		if (size <= MIN_COUNT)
			count = 0.2;

		if (size <= MEDIUM_COUNT && size > MIN_COUNT)
			count = 0.3;

		if (size > MEDIUM_COUNT && size < AVG_COUNT)
			count = 0.5;

		if (size >= AVG_COUNT)
			count = 0.6;

		if (size >= SUB_MAX_COUNT)
			count = 0.8;

		if (size == MAX_COUNT)
			count = 1.0;

		return count;
	}

}
