package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.Question;
import br.com.ufc.quixada.laurabot.api.repositories.IQuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private IQuestionRepository questionRepository;

	@Autowired
	private PostsService postsService;

	public List<Question> findByTag(String tag) {
		List<Long> ids = postsService.findPostsIdByTag(tag);
		return findByPostsId(ids);
	}

	@SuppressWarnings("unused")
	private List<Question> findAll() {
		return questionRepository.findAll();
	}

	private List<Question> findByPostsId(List<Long> postsId) {
		return questionRepository.findByPostsId(postsId);
	}

}
