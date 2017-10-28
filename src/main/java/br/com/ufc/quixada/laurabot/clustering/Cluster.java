package br.com.ufc.quixada.laurabot.clustering;

import java.util.ArrayList;
import java.util.List;

public class Cluster {

	private List<Question> questions;
	private Question centroid;
	private int id;

	public Cluster(int id) {
		this.id = id;
		this.questions = new ArrayList<Question>();
		this.centroid = null;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question getCentroid() {
		return centroid;
	}

	public void setCentroid(Question centroid) {
		this.centroid = centroid;
	}

	public int getId() {
		return id;
	}

	public void addQuestion(Question question) {
		if (this.questions != null) {
			this.questions.add(question);
		}
	}

	public void clearCluster() {
		if (this.questions.size() > 0) {
			this.questions.clear();
		}
	}

	public void plotCluster() {
		System.out.println("[Cluster: " + id + "]");
		System.out.println("[Centroid: " + centroid + "]");
		System.out.println("[Questions: \n");
		for (Question q : this.questions) {
			System.out.println(q);
		}
		System.out.println("]");
	}

	public boolean hasQuestion(Question question) {
		for (Question q : this.questions) {
			if (q.equals(question)) {
				return true;
			}
		}
		return false;
	}
}