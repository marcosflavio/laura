package br.com.ufc.quixada.laurabot.clustering.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.quixada.laurabot.api.model.Question;

public class Cluster {

	private List<Question> questions;

	private Question medoid;

	private int id;

	public Cluster(int id) {
		this.id = id;
		this.questions = new ArrayList<Question>();
		this.medoid = null;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> dQuestions) {
		this.questions = dQuestions;
	}

	public Question getMedoid() {
		return medoid;
	}

	public void setMedoid(Question medoid) {
		this.medoid = medoid;
	}

	public int getId() {
		return id;
	}

	public void addQuestion(Question dQuestion) {
		if (this.questions != null) {
			this.questions.add(dQuestion);
		}
	}

	public void clearCluster() {
		if (this.questions.size() > 0) {
			this.questions.clear();
		}
	}

	public boolean hasQuestion(Question questionReceived) {
		for (Question q : this.questions) {
			if (q.equals(questionReceived)) {
				return true;
			}
		}
		return false;
	}
}