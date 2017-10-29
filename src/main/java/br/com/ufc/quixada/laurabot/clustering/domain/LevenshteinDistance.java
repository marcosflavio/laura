package br.com.ufc.quixada.laurabot.clustering.domain;

import org.springframework.stereotype.Component;

import br.com.ufc.quixada.laurabot.api.model.Question;
import info.debatty.java.stringsimilarity.Levenshtein;

@Component
public class LevenshteinDistance {
	
	public LevenshteinDistance() {

	}

	public double calculateDistance(Question question, Question medoid) {
		Levenshtein levenshtein = new Levenshtein();
		return levenshtein.distance(question.getTitle(), medoid.getTitle());
	}

}
