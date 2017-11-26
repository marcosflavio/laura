package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.clustering.Kmeans;

@Service
public class ClusteringService {

	@Autowired
	private JavaQuestionService javaQuestionService;

	public Map<Integer, Double> clustering() {
		List<JavaQuestion> javaQuestions = javaQuestionService.findAll();
		Kmeans kmeans = new Kmeans(2, javaQuestions);
		return kmeans.calculateElbowMethod();
	}
}
