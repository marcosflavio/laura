package br.com.ufc.quixada.laurabot.metric.checkers.impl;

import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.metric.checkers.MetricChecker;

@Component
public class AcceptedAnswerChecker implements MetricChecker {

	@Override
	public Double check(JavaQuestion javaQuestion, JavaAnswer javaAnswer) {
		return null;
	}
}
