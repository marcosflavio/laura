package br.com.ufc.quixada.laurabot.clustering;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.clustering.domain.Cluster;
import br.com.ufc.quixada.laurabot.clustering.domain.LevenshteinDistance;
import br.com.ufc.quixada.laurabot.clustering.domain.commons.text.CommonsTextSimilarity;

public class Kmeans {

	private LevenshteinDistance levenshteinDistance;

	private int numClusters;

	private List<JavaQuestion> questions;

	private List<Cluster> clusters;

	private final Integer minK = 2;

	public Kmeans(int k, List<JavaQuestion> questions) {
		this.numClusters = k;
		this.questions = questions;
		this.clusters = new ArrayList<>();
		this.levenshteinDistance = new LevenshteinDistance();
	}

	private void init() {
		this.initClusters();
		this.setRandomMedoids();
	}

	private void initClusters() {
		for (int i = 0; i < this.numClusters; i++) {
			Cluster cluster = new Cluster(i);
			this.clusters.add(cluster);
		}
	}

	private void createNewClusterWithRandomMedoid(Integer id) {
		JavaQuestion newMedoid = createARandomMedoid(getMedoids());
		Cluster cluster = new Cluster(id);
		cluster.setMedoid(newMedoid);
		newMedoid.setClusterId(cluster.getId());
		this.clusters.add(cluster);
	}

	private List<Integer> generateAShuflledListOfNumbers(Integer maxValue) {
		List<Integer> possibleMedoids = new ArrayList<>();
		for (int i = 0; i < maxValue; i++) {
			possibleMedoids.add(i);
		}
		Collections.shuffle(possibleMedoids);
		return possibleMedoids;
	}

	private void setRandomMedoids() {
		List<Integer> possibleMedoids = generateAShuflledListOfNumbers(questions.size());

		for (int j = 0; j < this.numClusters; j++) {
			JavaQuestion medoid = questions.get(possibleMedoids.get(j));
			medoid.setClusterId(j);
			clusters.get(j).setMedoid(medoid);
		}
	}

	private JavaQuestion createARandomMedoid(List<JavaQuestion> actualMedoids) {
		Boolean isANotValidMedoid = true;
		Integer questionIndex = null;
		while (isANotValidMedoid) {
			questionIndex = generateAShuflledListOfNumbers(questions.size()).get(0);
			isANotValidMedoid = actualMedoids.contains(questions.get(questionIndex));
		}
		return questions.get(questionIndex);
	}

	private void plotClusters() {
		for (int i = 0; i < this.numClusters; i++) {
			Cluster cl = clusters.get(i);
			System.out.println("Centroid: " + cl.getMedoid() + "Size: " + cl.getQuestions().size());
			plotQuestions(cl.getQuestions(), cl.getId());
		}
	}

	private void plotQuestions(List<JavaQuestion> questions, Integer id) {
		FileWriter arquivo;
		try {
			arquivo = new FileWriter(
					new File("/home/marcos/clusters/" + new Date().toString() + "cluster " + id.toString() + ".txt"));
			for (JavaQuestion q : questions) {
				arquivo.write(q.getTitle());
				arquivo.write("\n");
			}
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clearClusters() {
		for (Cluster cluster : this.clusters) {
			cluster.clearCluster();
		}
	}

	private List<JavaQuestion> getMedoids() {
		List<JavaQuestion> medoids = new ArrayList<JavaQuestion>(this.numClusters);
		clusters.forEach(cluster -> {
			medoids.add(cluster.getMedoid());
		});
		return medoids;
	}

	private void assignCluster() {
		Double max = Double.MAX_VALUE;
		Double min = max;
		this.clearClusters();
		List<JavaQuestion> medoids = this.getMedoids();
		int clusterId = -1;
		for (int i = 0; i < this.questions.size(); i++) {

			if (validateString(questions.get(i).getTitle())) {
				for (int j = 0; j < medoids.size(); j++) {
					if (validateString(medoids.get(j).getTitle())) {
						// Double distanceLev =
						// levenshteinDistance.calculateDistance(questions.get(i),
						// medoids.get(j));
						Double distance = CommonsTextSimilarity.applyLongestCommonSubsequenceDistance(
								questions.get(i).getTitle(), medoids.get(j).getTitle()).doubleValue();

						if (distance < min) {
							min = distance;
							clusterId = medoids.get(j).getClusterId();
						}
					}
				}
				this.questions.get(i).setClusterId(clusterId);
				getClusterById(clusterId).addQuestion(this.questions.get(i));
				clusterId = -1;
				min = max;
			}

		}
	}

	private Boolean validateString(String someString) {
		return StringUtils.isNotBlank(someString) && StringUtils.isNotEmpty(someString);
	}

	private List<JavaQuestion> calculateMedoids() {
		double mean;
		double max = Double.POSITIVE_INFINITY;
		double dist = max;
		List<JavaQuestion> medoids = new ArrayList<>();
		for (int i = 0; i < clusters.size(); i++) {
			List<JavaQuestion> questions = clusters.get(i).getQuestions();

			if (questions.size() > 1) {
				questions.add(clusters.get(i).getMedoid());
				for (int j = 0; j < questions.size(); j++) {
					double sumDistance = 0;
					for (int k = 0; k < questions.size(); k++) {
						if (!questions.get(j).equals(questions.get(k))) {
							// sumDistance += levenshteinDistance.calculateDistance(questions.get(j),
							// questions.get(k));
							sumDistance += CommonsTextSimilarity.applyLongestCommonSubsequenceDistance(
									questions.get(j).getTitle(), questions.get(k).getTitle()).doubleValue();
						}
					}
					mean = sumDistance / (questions.size() - 1);

					if (mean < dist) {
						dist = mean;
						clusters.get(i).setMedoid(questions.get(j));
					}
				}
				clusters.get(i).getMedoid().setClusterId(clusters.get(i).getId());
				medoids.add(clusters.get(i).getMedoid());
				dist = max;
			}
		}
		return medoids;
	}

	private Double calculateMedoidsVariation(List<JavaQuestion> oldMedoids, List<JavaQuestion> newMedoids) {
		Double distanceSum = 0.0;

		for (int i = 0; i < oldMedoids.size(); i++) {
			distanceSum += levenshteinDistance.calculateDistance(oldMedoids.get(i), newMedoids.get(i));
		}

		return distanceSum;
	}

	@SuppressWarnings("unused")
	private int getNumClusters() {
		return numClusters;
	}

	@SuppressWarnings("unused")
	private void setNumClusters(int numClusters) {
		this.numClusters = numClusters;
	}

	@SuppressWarnings("unused")
	private List<JavaQuestion> getQuestions() {
		return questions;
	}

	@SuppressWarnings("unused")
	private void setQuestions(List<JavaQuestion> dQuestions) {
		this.questions = dQuestions;
	}

	@SuppressWarnings("unused")
	private List<Cluster> getClusters() {
		return this.clusters;
	}

	private Cluster getClusterById(int id) {
		for (int i = 0; i < this.clusters.size(); i++) {
			if (this.clusters.get(i).getId() == id) {
				return this.clusters.get(i);
			}
		}
		return null;
	}

	private void calculate() {
		int i = 0;
		while (i < 10) { // this 10 param is only temporally
			this.assignCluster();
			List<JavaQuestion> oldMedoids = getMedoids();
			this.plotClusters();
			List<JavaQuestion> newMedoids = this.calculateMedoids();
			this.calculateMedoidsVariation(oldMedoids, newMedoids);
			calculateMedoids();
			i++;
		}
	}

	private void calculateToElbow(Integer k) {
		if (k > minK)
			calculateMedoids();
		assignCluster();
	}

	public void doClustering() {
		init();
		calculate();
	}

	public Double calculateSSE() {
		Double distanceSum = 0.0;
		// Double distanceSumLev = 0.0;

		for (Cluster cluster : clusters) {
			JavaQuestion medoid = cluster.getMedoid();
			for (JavaQuestion question : cluster.getQuestions()) {
				// Double distanceLev = levenshteinDistance.calculateDistance(question, medoid);
				Double distance = CommonsTextSimilarity
						.applyLongestCommonSubsequenceDistance(question.getTitle(), medoid.getTitle()).doubleValue();
				distanceSum += distance * distance;
				// distanceSumLev += distanceLev * distanceLev;
			}
		}

		return distanceSum;
	}

	public Map<Integer, Double> calculateElbowMethod() {
		Integer k = numClusters;
		Integer maxK = 301;

		Map<Integer, Double> SSE = new HashMap<>();

		init();

		for (; k < maxK; k++) {
			System.out.println("K = " + k);
			this.numClusters = k;

			if (k != minK) {
				createNewClusterWithRandomMedoid(k);
			}

			calculateToElbow(k);
			SSE.put(k, calculateSSE());
			System.out.println("Fim do calculo de K = " + k);

			System.out.println("Clusters size: " + clusters.size());
			System.out.println("Medoids size: " + getMedoids().size());
			System.out.println("SSE of k = " + k + " : " + SSE.get(k));
		}
		return SSE;
	}
}