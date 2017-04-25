package br.com.ufc.quixada.laurabot.clustering;

import info.debatty.java.stringsimilarity.Levenshtein;

public class LevenshteinDistance {
	// Calculates the distance between two questions.
	public double calculateDistance(Question q, Question centroid) {
		Levenshtein levenshtein = new Levenshtein();
		return levenshtein.distance(q.getTitle(), centroid.getTitle());
	}
}
