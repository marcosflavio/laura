package br.com.ufc.quixada.laurabot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.quixada.laurabot.model.PostsEntity;
import br.com.ufc.quixada.laurabot.service.PostsService;

@RestController
@RequestMapping(value = "/laura/questions")
public class LauraController {
	@Autowired
	private PostsService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PostsEntity> findAll() {
		return service.findAllQuestions(1L);
	}
}
