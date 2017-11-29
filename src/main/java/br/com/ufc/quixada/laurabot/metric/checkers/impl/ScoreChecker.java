package br.com.ufc.quixada.laurabot.metric.checkers.impl;

import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.metric.checkers.MetricChecker;

@Component
public class ScoreChecker implements MetricChecker {

	private static Long MAX_SCORE = 107L;

	private static Long MIN_SCORE = -4L;

	private static Long AVG_SCORE = 3L;

	private static Long SUB_MAX_SCORE = 80L;

	@Override
	public Double check(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		Double score = 0.0;

		if (javaAnswer.getScore().equals(MIN_SCORE))
			score = 0.0;

		if (javaAnswer.getScore() <= AVG_SCORE && javaAnswer.getScore() > MIN_SCORE)
			score = 0.25;

		if (javaAnswer.getScore() >= AVG_SCORE)
			score = 0.5;

		if (javaAnswer.getScore() >= SUB_MAX_SCORE)
			score = 0.75;

		if (javaAnswer.getScore().equals(MAX_SCORE))
			score = 1.0;

		return score;
	}

}
