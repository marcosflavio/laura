package br.com.ufc.quixada.laurabot.clustering;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.com.ufc.quixada.laurabot.clustering.domain.Cluster;
import br.com.ufc.quixada.laurabot.clustering.domain.LevenshteinDistance;
import br.com.ufc.quixada.laurabot.clustering.domain.DQuestion;

public class Kmeans {
	private int numClusters;
	private List<DQuestion> dQuestions;
	private List<Cluster> clusters;

	public Kmeans(int k, List<DQuestion> dQuestions) {
		this.numClusters = k;
		this.dQuestions = dQuestions;
		this.clusters = new ArrayList<>();
	}

	private void init() {
		this.initClusters();
		this.setRandomCentroids();
	}

	private void initClusters() {
		for (int i = 0; i < this.numClusters; i++) {
			Cluster cluster = new Cluster(i);
			this.clusters.add(cluster);
		}
	}
	
	private void setRandomCentroids() {
		List<Integer> possibleCentroids = new ArrayList<>();
		for (int i = 0; i < this.dQuestions.size(); i++) {
			possibleCentroids.add(i);
		}
		Collections.shuffle(possibleCentroids);
		for (int j = 0; j < this.numClusters; j++) {
			DQuestion centroid = dQuestions.get(possibleCentroids.get(j));
			centroid.setClusterId(j);
			clusters.get(j).setCentroid(centroid);
		}
	}

	private void plotClusters() {
		for (int i = 0; i < this.numClusters; i++) {
			Cluster cl = clusters.get(i);
			System.out.println("Centroid: " + cl.getCentroid() + "Size: " + cl.getQuestions().size());
			plotQuestions(cl.getQuestions(), cl.getId());
		}
	}
	
	private void plotQuestions(List<DQuestion> dQuestions, Integer id) {
		FileWriter arquivo;
			try {  
	            arquivo = new FileWriter(new File("/home/marcos/clusters/" + new Date().toString() + "cluster " + id.toString() +".txt"));  
	            for(DQuestion q : dQuestions){
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

	private List<DQuestion> getCentroids() {
		List<DQuestion> centroids = new ArrayList<DQuestion>(this.numClusters);
		for (Cluster cluster : this.clusters) {
			DQuestion aux = cluster.getCentroid();
			DQuestion dQuestion = new DQuestion(aux.getTitle(), aux.getId());
			dQuestion.setClusterId(aux.getClusterId());
			centroids.add(dQuestion);
		}
		return centroids;
	}

	private void assignCluster() {
		Double max = Double.MAX_VALUE;
		Double min = max;
		LevenshteinDistance levenshtein = new LevenshteinDistance();
		this.clearClusters();
		List<DQuestion> centroids = this.getCentroids();
		int clusterId = -1;
		for (int i = 0; i < this.dQuestions.size(); i++) {
			for (int j = 0; j < centroids.size(); j++) {
				Double distance = levenshtein.calculateDistance(dQuestions.get(i), centroids.get(j));
				if (distance < min) {
					min = distance;
					clusterId = centroids.get(j).getClusterId();
				}
			}
			this.dQuestions.get(i).setClusterId(clusterId);
			getClusterById(clusterId).addQuestion(this.dQuestions.get(i));
			clusterId = -1;
			min = max;
		}
	}
	
	private List<DQuestion> calculateCentroids() {
		LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
		double mean;
		double max = Double.POSITIVE_INFINITY;
		double dist = max;
		List<DQuestion> centroids = new ArrayList<>();
		for (int i = 0; i < clusters.size(); i++) {
			List<DQuestion> dQuestions = clusters.get(i).getQuestions();
			dQuestions.add(clusters.get(i).getCentroid());
			for (int j = 0; j < dQuestions.size(); j++) {
				double sumDistance = 0;
				for (int k = 0; k < dQuestions.size(); k++) {
					if (!dQuestions.get(j).equals(dQuestions.get(k))) {
						sumDistance += levenshteinDistance.calculateDistance(dQuestions.get(j), dQuestions.get(k));
					}
				}
				mean = sumDistance / (dQuestions.size() - 1);

				if (mean < dist) {
					dist = mean;
					clusters.get(i).setCentroid(dQuestions.get(j));
				}
			}
			clusters.get(i).getCentroid().setClusterId(clusters.get(i).getId());
			centroids.add(clusters.get(i).getCentroid());
			dist = max;
		}
		return centroids;
	}

	@SuppressWarnings("unused")
	private Double calculateCentroidsPercentVariation(List<DQuestion> oldCentroids, List<DQuestion> newCentroids) {
		double distance = 0.0;
		LevenshteinDistance levenshtein = new LevenshteinDistance();
		for (int i = 0; i < oldCentroids.size(); i++) {
			distance += levenshtein.calculateDistance(oldCentroids.get(i), newCentroids.get(i));
		}
		double mean = (distance / oldCentroids.size());
		return mean;
	}

	private int getNumClusters() {
		return numClusters;
	}
	
	@SuppressWarnings("unused")
	private void setNumClusters(int numClusters) {
		this.numClusters = numClusters;
	}
	
	@SuppressWarnings("unused")
	private List<DQuestion> getQuestions() {
		return dQuestions;
	}
	
	@SuppressWarnings("unused")
	private void setQuestions(List<DQuestion> dQuestions) {
		this.dQuestions = dQuestions;
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
		System.err.println("Comecei a calcular..");
		while (i < this.getNumClusters()) {
			this.assignCluster();
			// oldCentroids = getCentroids();
			System.err.println("Inicio da " + i + " iteração");
			this.plotClusters();
			// newCentroids = this.calculateCentroids();
			// this.calculateCentroidsPercentVariation(oldCentroids,
			// newCentroids);
			System.err.println("Fim da " + i + " iteração");
			calculateCentroids();
			i++;
		}
	}
	
	public void doClustering() {
		init();
		calculate();
	}
}