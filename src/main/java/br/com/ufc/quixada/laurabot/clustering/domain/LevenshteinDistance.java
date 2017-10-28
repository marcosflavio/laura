package br.com.ufc.quixada.laurabot.clustering.domain;

import info.debatty.java.stringsimilarity.Levenshtein;

public class LevenshteinDistance {
	
	public LevenshteinDistance() {

	}

	public double calculateDistance(DQuestion q, DQuestion centroid) {
		Levenshtein levenshtein = new Levenshtein();
		return levenshtein.distance(q.getTitle(), centroid.getTitle());
	}

}
