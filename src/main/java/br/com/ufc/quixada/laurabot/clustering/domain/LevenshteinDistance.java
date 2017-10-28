package br.com.ufc.quixada.laurabot.clustering.domain;

import org.springframework.stereotype.Component;

import info.debatty.java.stringsimilarity.Levenshtein;

@Component
public class LevenshteinDistance {
	
	public LevenshteinDistance() {

	}

	public double calculateDistance(DQuestion question, DQuestion medoid) {
		Levenshtein levenshtein = new Levenshtein();
		return levenshtein.distance(question.getTitle(), medoid.getTitle());
	}

}
