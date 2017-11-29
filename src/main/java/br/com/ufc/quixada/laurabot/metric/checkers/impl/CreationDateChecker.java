package br.com.ufc.quixada.laurabot.metric.checkers.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.metric.checkers.MetricChecker;

@Component
public class CreationDateChecker implements MetricChecker {

	private static int YEAR_2017 = 117;

	private static int YEAR_2016 = 116;

	private static int YEAR_2015 = 115;

	private static int YEAR_2014 = 114;

	private static int YEAR_2013 = 113;

	@SuppressWarnings("deprecation")
	@Override
	public Double check(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		Double creationDate = 0.0;

		Date creationDateOfUser = javaAnswer.getUser().getCreationDate();

		if (creationDateOfUser.getYear() == YEAR_2013)
			creationDate = 1.0;

		if (creationDateOfUser.getYear() == YEAR_2014)
			creationDate = 0.8;

		if (creationDateOfUser.getYear() == YEAR_2015)
			creationDate = 0.6;

		if (creationDateOfUser.getYear() == YEAR_2016)
			creationDate = 0.4;

		if (creationDateOfUser.getYear() == YEAR_2017)
			creationDate = 0.2;

		return creationDate;
	}

}
