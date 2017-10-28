package br.com.ufc.quixada.laurabot.clustering.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.Question;
import br.com.ufc.quixada.laurabot.clustering.domain.DQuestion;

@Service
public class DQuestionService {
	
	public List<DQuestion> transformToDomainQuestion (List<Question> questions){
		List<DQuestion> dQuestions = new ArrayList<DQuestion>();

		questions.forEach(question -> {
			DQuestion dQuestion = new DQuestion(question.getTitle(), question.getId());
			dQuestions.add(dQuestion);
		});
		
		return dQuestions;
	}
}
