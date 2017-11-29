package br.com.ufc.quixada.laurabot.metric.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;
import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.services.JavaAnswerService;
import br.com.ufc.quixada.laurabot.api.services.JavaQuestionService;
import br.com.ufc.quixada.laurabot.metric.analyzers.AnswerAnalyzer;
import br.com.ufc.quixada.laurabot.metric.model.LauraAnswerMetric;

@Service
public class AnswerRankService {

	private List<AnswerAnalyzer> analyzers;

	@Autowired
	private JavaAnswerService javaAnswerService;

	@Autowired
	private JavaQuestionService javaQuestionService;

	@Autowired
	public AnswerRankService(List<AnswerAnalyzer> analyzers) {
		this.analyzers = analyzers;
	}

	public void process() {
		List<JavaQuestion> javaQuestions = javaQuestionService.findAll();
		javaQuestions.forEach(question -> {
			List<JavaAnswer> answers = question.getJavaAnswers();
			answers.forEach(answer -> {
				LauraAnswerMetric lam = new LauraAnswerMetric();
				analyzers.forEach(analyzer -> {
					analyzer.analyze(question, answer, lam);
				});
				answer.setRankValue(lam.getRankValue());
				javaAnswerService.save(answer);
			});

		});
	}
}
