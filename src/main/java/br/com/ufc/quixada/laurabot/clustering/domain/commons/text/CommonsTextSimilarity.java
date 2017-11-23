package br.com.ufc.quixada.laurabot.clustering.domain.commons.text;

import org.apache.commons.text.similarity.CosineDistance;
import org.apache.commons.text.similarity.JaccardDistance;
import org.apache.commons.text.similarity.JaccardSimilarity;
import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.apache.commons.text.similarity.LongestCommonSubsequenceDistance;

public class CommonsTextSimilarity {

	// Measures the cosine distance between two character sequences.
	public static Double applyCosineDistance(String medoid, String question) {
		return new CosineDistance().apply(medoid, question);
	}

	// Measures the Jaccard similarity (aka Jaccard index) of two sets of
	// character sequence.
	public static Double applyJaccardSimilarity(String medoid, String question) {
		return new JaccardSimilarity().apply(medoid, question);
	}

	// Measures the Jaccard distance of two sets of character sequence.
	public static Double applyJaccardDistance(String medoid, String question) {
		return new JaccardDistance().apply(medoid, question);
	}

	// A similarity algorithm indicating the percentage of matched characters
	// between two character sequences.
	public static Double applyJaroWinklerDistance(String medoid, String question) {
		return new JaroWinklerDistance().apply(medoid, question);
	}

	// An algorithm for measuring the difference between two character
	// sequences.
	public static Integer applyLevenshteinDistance(String medoid, String question) {
		return new LevenshteinDistance().apply(medoid, question);
	}

	// An edit distance algorithm based on the length of the longest common
	// subsequence between two strings.
	public static Integer applyLongestCommonSubsequenceDistance(String medoid, String question) {
		return new LongestCommonSubsequenceDistance().apply(medoid, question);
	}
}
