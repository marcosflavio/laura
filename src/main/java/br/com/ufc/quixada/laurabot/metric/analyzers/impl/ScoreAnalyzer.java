package br.com.ufc.quixada.laurabot.metric.analyzers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.metric.analyzers.AnswerAnalyzer;
import br.com.ufc.quixada.laurabot.metric.checkers.impl.ScoreChecker;
import br.com.ufc.quixada.laurabot.metric.model.LauraAnswerMetric;

@Component
public class ScoreAnalyzer implements AnswerAnalyzer {

	@Autowired
	private ScoreChecker scoreChecker;
	
	@Override
	public void analyze(JavaQuestion javaQuestion, JavaAnswer javaAnswer, LauraAnswerMetric lauraAnswerMetric) {
		Double scoreValue = scoreChecker.check(javaQuestion, javaAnswer);
		lauraAnswerMetric.setScoreValue(scoreValue);
	}

}
