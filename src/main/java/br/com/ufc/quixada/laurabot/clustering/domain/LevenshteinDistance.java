package br.com.ufc.quixada.laurabot.clustering.domain;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import info.debatty.java.stringsimilarity.Levenshtein;

public class LevenshteinDistance {
	
	public LevenshteinDistance() {

	}

	public double calculateDistance(JavaQuestion question, JavaQuestion medoid) {
		Levenshtein levenshtein = new Levenshtein();
		return levenshtein.distance(question.getTitle(), medoid.getTitle());
	}

}
