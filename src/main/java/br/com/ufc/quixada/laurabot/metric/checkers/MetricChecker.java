package br.com.ufc.quixada.laurabot.metric.checkers;

import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;

@Component
public interface MetricChecker {
	public Double check(JavaQuestion javaQuestion, JavaAnswer javaAnswer);
}
