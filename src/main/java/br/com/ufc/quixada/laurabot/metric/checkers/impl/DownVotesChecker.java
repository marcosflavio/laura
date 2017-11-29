package br.com.ufc.quixada.laurabot.metric.checkers.impl;

import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.model.User;
import br.com.ufc.quixada.laurabot.metric.checkers.MetricChecker;

@Component
public class DownVotesChecker implements MetricChecker {
	
	private static int MAX_DOWN_VOTES = 6277;

	private static int MIN_DOWN_VOTES = 0;

	private static int AVG_DOWN_VOTES = 1;

	private static int SUB_MAX_DOWN_VOTES = 4707;
	
	@Override
	public Double check(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		Double downVotes = 0.0;

		User user = javaAnswer.getUser();

		if (user.getDownVotes() == MIN_DOWN_VOTES)
			downVotes = 1.0;

		if (user.getDownVotes() <= AVG_DOWN_VOTES && user.getDownVotes() > MIN_DOWN_VOTES)
			downVotes = 0.75;

		if (user.getDownVotes() >= AVG_DOWN_VOTES)
			downVotes = 0.5;

		if (user.getDownVotes() >= SUB_MAX_DOWN_VOTES)
			downVotes = 0.25;

		if (user.getDownVotes() == MAX_DOWN_VOTES)
			downVotes = 0.0;

		return downVotes;
	}

}
