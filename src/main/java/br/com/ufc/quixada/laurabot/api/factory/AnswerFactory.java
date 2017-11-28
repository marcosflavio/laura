package br.com.ufc.quixada.laurabot.api.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.Answer;
import br.com.ufc.quixada.laurabot.api.model.Post;
import br.com.ufc.quixada.laurabot.api.model.Question;
import br.com.ufc.quixada.laurabot.api.model.User;
import br.com.ufc.quixada.laurabot.api.services.AnswerService;
import br.com.ufc.quixada.laurabot.api.services.PostsService;
import br.com.ufc.quixada.laurabot.api.services.QuestionService;

@Component
public class AnswerFactory {

	@Autowired
	private PostsService postsService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	public void create() {
		List<Post> originalAnswers = postsService.findPostsByType(2L);
		
		originalAnswers.forEach(original -> {
			
			Answer answer = new Answer();
			
			Long userId = original.getOwnerUserId();
			
			if(userId != null) {
				User user = new User(userId);
				
				answer.setUser(user);
				
				answer.setBody(original.getBody());
				answer.setCreationDate(original.getCreationDate());
				answer.setFavoriteCount(original.getFavoriteCount());
				answer.setScore(original.getScore());
				answer.setTags(original.getTags());
				answer.setPost(original);
				
				
				Question question = questionService.findByPostId(original.getParentId());
				answer.setQuestion(question);
				
				answerService.save(answer);
			}
			
		});
		
	}
}
