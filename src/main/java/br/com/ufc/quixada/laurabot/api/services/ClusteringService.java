package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.Question;
import br.com.ufc.quixada.laurabot.clustering.Kmeans;
import br.com.ufc.quixada.laurabot.clustering.domain.DQuestion;
import br.com.ufc.quixada.laurabot.clustering.services.DQuestionService;

@Service
public class ClusteringService {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private DQuestionService dQuestionService;
	
	public void clustering() {
		List<Question> questions = questionService.findAll();
		List<DQuestion> dQuestions = dQuestionService.transformToDomainQuestion(questions);
		Kmeans kmeans = new Kmeans (10, dQuestions);
		kmeans.doClustering();
	}
}
