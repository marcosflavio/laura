package br.com.ufc.quixada.laurabot.metric.checkers.impl;

import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.model.User;
import br.com.ufc.quixada.laurabot.metric.checkers.MetricChecker;

@Component
public class ReputationChecker implements MetricChecker {

	private static int MAX_REPUTATION = 187310;

	private static int MIN_REPUTATION = 1;

	private static int AVG_REPUTATION = 79;

	private static int SUB_MAX_REPUTATION = 140482;

	@Override
	public Double check(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		Double reputation = 0.0;

		User user = javaAnswer.getUser();

		if (user.getReputation() == MIN_REPUTATION)
			reputation = 0.0;

		if (user.getReputation() <= AVG_REPUTATION && user.getReputation() > MIN_REPUTATION)
			reputation = 0.25;

		if (user.getReputation() >= AVG_REPUTATION)
			reputation = 0.5;

		if (user.getReputation() >= SUB_MAX_REPUTATION)
			reputation = 0.75;

		if (user.getReputation() == MAX_REPUTATION)
			reputation = 1.0;

		return reputation;
	}

}
