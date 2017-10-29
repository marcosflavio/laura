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

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ufc.quixada.laurabot.api.model.Question;
import br.com.ufc.quixada.laurabot.clustering.domain.Cluster;
import br.com.ufc.quixada.laurabot.clustering.domain.LevenshteinDistance;

public class Kmeans {
	
	@Autowired
	private LevenshteinDistance levenshteinDistance;
	
	private int numClusters;
	
	private List<Question> questions;
	
	private List<Cluster> clusters;

	public Kmeans(int k, List<Question> questions) {
		this.numClusters = k;
		this.questions = questions;
		this.clusters = new ArrayList<>();
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
	
	private void setRandomMedoids() {
		List<Integer> possibleMedoids = new ArrayList<>();
		for (int i = 0; i < this.questions.size(); i++) {
			possibleMedoids.add(i);
		}
		Collections.shuffle(possibleMedoids);
		for (int j = 0; j < this.numClusters; j++) {
			Question medoid = questions.get(possibleMedoids.get(j));
			medoid.setClusterId(j);
			clusters.get(j).setMedoid(medoid);
		}
	}

	private void plotClusters() {
		for (int i = 0; i < this.numClusters; i++) {
			Cluster cl = clusters.get(i);
			System.out.println("Centroid: " + cl.getMedoid() + "Size: " + cl.getQuestions().size());
			plotQuestions(cl.getQuestions(), cl.getId());
		}
	}
	
	private void plotQuestions(List<Question> questions, Integer id) {
		FileWriter arquivo;
			try {  
	            arquivo = new FileWriter(new File("/home/marcos/clusters/" + new Date().toString() + "cluster " + id.toString() +".txt"));  
	            for(Question q : questions){
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
	
	private void resetClusters() {
		this.clusters.clear();
	}
	
	private void clearClusters() {
		for (Cluster cluster : this.clusters) {
			cluster.clearCluster();
		}
	}

	private List<Question> getMedoids() {
		List<Question> medoids = new ArrayList<Question>(this.numClusters);
		clusters.forEach(cluster -> {
			medoids.add(cluster.getMedoid());
		});
		return medoids;
	}

	private void assignCluster() {
		Double max = Double.MAX_VALUE;
		Double min = max;
		this.clearClusters();
		List<Question> medoids = this.getMedoids();
		int clusterId = -1;
		for (int i = 0; i < this.questions.size(); i++) {
			for (int j = 0; j < medoids.size(); j++) {
				Double distance = levenshteinDistance.calculateDistance(questions.get(i), medoids.get(j));
				if (distance < min) {
					min = distance;
					clusterId = medoids.get(j).getClusterId();
				}
			}
			this.questions.get(i).setClusterId(clusterId);
			getClusterById(clusterId).addQuestion(this.questions.get(i));
			clusterId = -1;
			min = max;
		}
	}
	
	private List<Question> calculateMedoids() {
		double mean;
		double max = Double.POSITIVE_INFINITY;
		double dist = max;
		List<Question> medoids = new ArrayList<>();
		for (int i = 0; i < clusters.size(); i++) {
			List<Question> questions = clusters.get(i).getQuestions();
			questions.add(clusters.get(i).getMedoid());
			for (int j = 0; j < questions.size(); j++) {
				double sumDistance = 0;
				for (int k = 0; k < questions.size(); k++) {
					if (!questions.get(j).equals(questions.get(k))) {
						sumDistance += levenshteinDistance.calculateDistance(questions.get(j), questions.get(k));
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
		return medoids;
	}
	
	private Double calculateMedoidsVariation(List<Question> oldMedoids, List<Question> newMedoids) {
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
	private List<Question> getQuestions() {
		return questions;
	}
	
	@SuppressWarnings("unused")
	private void setQuestions(List<Question> dQuestions) {
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
		while (i < 10) { //this 10 param is only temporally
			this.assignCluster();
			List<Question> oldMedoids = getMedoids();
			this.plotClusters();
			List<Question> newMedoids = this.calculateMedoids();
			this.calculateMedoidsVariation(oldMedoids, newMedoids);
			calculateMedoids();
			i++;
		}
	}
	
	private void calculateToElbow() {
		assignCluster();
		calculateMedoids();
	}
	
	public void doClustering() {
		init();
		calculate();
	}
	
	public Double calculateSSE() {
		Double distanceSum = 0.0;
		for (Cluster cluster : clusters) {
			Question medoid = cluster.getMedoid();
			for (Question question : cluster.getQuestions()) {
				Double distance = levenshteinDistance.calculateDistance(question, medoid);
				distanceSum += distance * distance;
			}
		}
		return distanceSum;
	}

	public Map<Integer, Double> calculateElbowMethod() {
		Integer k = numClusters;
		Integer maxK = 20;
		Map<Integer, Double> SSE = new HashMap<>();

		init();

		for (; k < maxK; k++) {
			this.numClusters = k;
			if (k != 2)
				initClusters();

			calculateToElbow();
			SSE.put(k, calculateSSE());
			resetClusters();
		}
		return SSE;
	}
}