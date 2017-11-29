package br.com.ufc.quixada.laurabot.metric.analyzers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.metric.analyzers.AnswerAnalyzer;
import br.com.ufc.quixada.laurabot.metric.checkers.impl.CreationDateChecker;
import br.com.ufc.quixada.laurabot.metric.model.LauraAnswerMetric;

@Component
public class CreationDateAnalyzer implements AnswerAnalyzer {
	
	@Autowired
	private CreationDateChecker creationDateChecker;
	
	@Override
	public void analyze(JavaQuestion javaQuestion, JavaAnswer javaAnswer, LauraAnswerMetric lauraAnswerMetric) {
		Double creationDateValue = creationDateChecker.check(javaQuestion, javaAnswer);
		lauraAnswerMetric.setCreationDateValue(creationDateValue);
	}

}
