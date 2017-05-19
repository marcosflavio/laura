package br.com.ufc.quixada.laurabot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.quixada.laurabot.clustering.Kmeans;
import br.com.ufc.quixada.laurabot.clustering.Question;
import br.com.ufc.quixada.laurabot.clustering.QuestionService;
import br.com.ufc.quixada.laurabot.model.PostsEntity;
import br.com.ufc.quixada.laurabot.service.PostsService;

@RestController
@RequestMapping(value = "/laura/questions")
public class LauraController {
	@Autowired
	private PostsService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PostsEntity> findAll() {
		return service.findPostsByType(1L);
	}
	
	@RequestMapping(value = "/clustering", method = RequestMethod.GET)
	public void clustering () {
		QuestionService qs = new QuestionService();
		Kmeans kmeans = new Kmeans (500);
		List<Question> questions = qs.transformToQuestion(service.findPostsByType(1L));
		kmeans.setQuestions(questions);
		kmeans.init();
		kmeans.calculate();
	}
}
