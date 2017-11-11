package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.Question;
import br.com.ufc.quixada.laurabot.clustering.Kmeans;

@Service
public class ClusteringService {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private PostsService postsService;
	
	public Map<Integer, Double> clustering() {
		List<Long> ids = postsService.findPostsIdByTag("<java>");
		
		List<Question> questions = questionService.findByPostsId(ids);
		
		Kmeans kmeans = new Kmeans (2, questions);
		
		return kmeans.calculateElbowMethod();
	}
}
