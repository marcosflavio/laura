package br.com.ufc.quixada.laurabot.clustering.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;

public class Cluster {

	private List<JavaQuestion> questions;

	private JavaQuestion medoid;

	private int id;

	public Cluster(int id) {
		this.id = id;
		this.questions = new ArrayList<JavaQuestion>();
		this.medoid = null;
	}

	public List<JavaQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<JavaQuestion> dQuestions) {
		this.questions = dQuestions;
	}

	public JavaQuestion getMedoid() {
		return medoid;
	}

	public void setMedoid(JavaQuestion medoid) {
		this.medoid = medoid;
	}

	public int getId() {
		return id;
	}

	public void addQuestion(JavaQuestion dQuestion) {
		if (this.questions != null) {
			this.questions.add(dQuestion);
		}
	}

	public void clearCluster() {
		if (this.questions.size() > 0) {
			this.questions.clear();
		}
	}

	public boolean hasQuestion(JavaQuestion questionReceived) {
		return this.questions.contains(questionReceived);
	}
}