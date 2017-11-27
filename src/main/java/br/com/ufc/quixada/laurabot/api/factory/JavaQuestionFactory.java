package br.com.ufc.quixada.laurabot.api.factory;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.model.Post;
import br.com.ufc.quixada.laurabot.api.model.User;
import br.com.ufc.quixada.laurabot.api.services.JavaQuestionService;
import br.com.ufc.quixada.laurabot.api.services.PostsService;

@Component
public class JavaQuestionFactory {

	@Autowired
	private PostsService postsService;
	
	@Autowired
	private JavaQuestionService javaQuestionService;
	
	/* public void create() {
		List<Question> javaQuestions = questionService.findByTag("<java>");

		javaQuestions.forEach(question -> {
			JavaQuestion javaQuestion = new JavaQuestion();
			javaQuestion.setPost(question.getPost());
			javaQuestion.setTitle(question.getTitle());
			javaQuestionService.save(javaQuestion);
		});
	} */
	
	
	public void bulkSetUser() {
		List<JavaQuestion> javaQuestions = javaQuestionService.findAll();
		
		javaQuestions.forEach( java -> {
			
			Post post = postsService.findOne(java.getPost().getId());
			
			Long userId = post.getOwnerUserId();
			
			if(userId != null) {
				User user = new User(userId);
				java.setUser(user);
				javaQuestionService.save(java);
			}
			
			
		});
	}
}
