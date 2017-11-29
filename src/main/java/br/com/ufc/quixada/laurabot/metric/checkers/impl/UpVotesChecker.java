package br.com.ufc.quixada.laurabot.metric.checkers.impl;

import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.model.User;
import br.com.ufc.quixada.laurabot.metric.checkers.MetricChecker;

@Component
public class UpVotesChecker implements MetricChecker {
	
	private static int MAX_UP_VOTES = 10043;

	private static int MIN_UP_VOTES = 0;

	private static int AVG_UP_VOTES = 7;

	private static int SUB_MAX_UP_VOTES = 7532;
	
	@Override
	public Double check(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		Double upVotes = 0.0;

		User user = javaAnswer.getUser();

		if (user.getUpVotes() == MIN_UP_VOTES)
			upVotes = 0.0;

		if (user.getUpVotes() <= AVG_UP_VOTES && user.getUpVotes() > MIN_UP_VOTES)
			upVotes = 0.25;

		if (user.getUpVotes() >= AVG_UP_VOTES)
			upVotes = 0.5;

		if (user.getUpVotes() >= SUB_MAX_UP_VOTES)
			upVotes = 0.75;

		if (user.getUpVotes() == MAX_UP_VOTES)
			upVotes = 1.0;

		return upVotes;
	}

}
