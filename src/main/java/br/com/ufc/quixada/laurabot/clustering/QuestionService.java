package br.com.ufc.quixada.laurabot.clustering;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.quixada.laurabot.model.PostsEntity;

public class QuestionService {
	
	public QuestionService() {

	}
	
	public List<Question> transformToQuestion (List<PostsEntity> posts){
		List<Question> questions = new ArrayList<Question>();
		for(int i = 0; i < posts.size(); i++){
			Question q = new Question(posts.get(i).getTitle(), posts.get(i).getId());
			questions.add(q);
			q = null;
		}
		return questions;
	}
}
