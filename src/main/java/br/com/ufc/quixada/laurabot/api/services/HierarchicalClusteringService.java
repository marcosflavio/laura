package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.clustering.Hierarchy;

public class HierarchicalClusteringService {

	@Autowired
	private JavaQuestionService javaQuestionService;

	public void clustering() {
		List<JavaQuestion> questions = javaQuestionService.findAll();
		Hierarchy h = new Hierarchy(questions);
		h.generate();
	}

}