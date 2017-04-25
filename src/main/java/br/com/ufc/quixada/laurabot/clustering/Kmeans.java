package br.com.ufc.quixada.laurabot.clustering;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kmeans {
	private int numClusters;
	private List<Question> questions;
	private List<Cluster> clusters;
	
	
	public Kmeans(int k){
		this.numClusters = k;
		this.questions = new ArrayList<>();
		this.clusters = new ArrayList<>();
	}
	
	
	public void init (){
		initClusters();
		setRandomCentroids();
	}
	
	private void initClusters(){
		for(int i = 0; i < this.numClusters; i++){
			Cluster cluster = new Cluster(i);
			this.clusters.add(cluster);
		}
	}
	
	private void setRandomCentroids(){
		for(int i = 0; i < this.numClusters; i++){
			int c = new Random().nextInt(questions.size());
			Question centroid = questions.get(c);
			centroid.setClusterId(i);
			clusters.get(i).setCentroid(centroid);
		}
	}
	
	public void plotClusters(){
		for(int i = 0; i < this.numClusters; i++){
			Cluster cl = clusters.get(i);
			cl.plotCluster();
		}
	}
	
	public void clearClusters(){
		for(Cluster cluster : this.clusters){
			cluster.clearCluster();
		}
	}
	
	public List<Question> getCentroids(){
		List<Question> centroids = new ArrayList<Question>(this.numClusters);
		for(Cluster cluster : this.clusters){
			Question aux = cluster.getCentroid();
			Question question = new Question(aux.getTitle(), aux.getId());
			centroids.add(question);
		}
		return centroids;
	}
	
	public void assignCluster(){
		//TODO
	}
	
	public Question calculateCentroid(Cluster cluster){
		//TODO
		return null;
	}
	
	public int getNumClusters() {
		return numClusters;
	}

	public void setNumClusters(int numClusters) {
		this.numClusters = numClusters;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public List<Cluster> getClusters() {
		return clusters;
	}
}
