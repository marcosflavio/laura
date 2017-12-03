package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.clustering.Kmeans;

@Service
public class ClusteringService {

	@Autowired
	private JavaQuestionService javaQuestionService;
	
	@Autowired
	private Kmeans kmeans;
	
	public void clustering() {
		List<JavaQuestion> javaQuestions = javaQuestionService.findAll();
		kmeans.start(90, javaQuestions);
		kmeans.doClustering();
	}
}
