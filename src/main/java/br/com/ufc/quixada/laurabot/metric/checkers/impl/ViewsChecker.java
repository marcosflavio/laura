package br.com.ufc.quixada.laurabot.metric.checkers.impl;

import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.model.User;
import br.com.ufc.quixada.laurabot.metric.checkers.MetricChecker;

@Component
public class ViewsChecker implements MetricChecker {
	
	private static int MAX_VIEWS = 12411;

	private static int MIN_VIEWS = 0;

	private static int AVG_VIEWS = 7;

	private static int SUB_MAX_VIEWS = 9308;
	
	@Override
	public Double check(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		Double views = 0.0;

		User user = javaAnswer.getUser();

		if (user.getViews() == MIN_VIEWS)
			views = 0.0;

		if (user.getViews() <= AVG_VIEWS && user.getViews() > MIN_VIEWS)
			views = 0.25;

		if (user.getViews() >= AVG_VIEWS)
			views = 0.5;

		if (user.getViews() >= SUB_MAX_VIEWS)
			views = 0.75;

		if (user.getViews() == MAX_VIEWS)
			views = 1.0;

		return views;
	}

}
