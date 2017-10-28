package br.com.ufc.quixada.laurabot.clustering.domain;

import java.util.ArrayList;
import java.util.List;

public class Cluster {

	private List<DQuestion> dQuestions;

	private DQuestion medoid;

	private int id;

	public Cluster(int id) {
		this.id = id;
		this.dQuestions = new ArrayList<DQuestion>();
		this.medoid = null;
	}

	public List<DQuestion> getQuestions() {
		return dQuestions;
	}

	public void setQuestions(List<DQuestion> dQuestions) {
		this.dQuestions = dQuestions;
	}

	public DQuestion getMedoid() {
		return medoid;
	}

	public void setMedoid(DQuestion medoid) {
		this.medoid = medoid;
	}

	public int getId() {
		return id;
	}

	public void addQuestion(DQuestion dQuestion) {
		if (this.dQuestions != null) {
			this.dQuestions.add(dQuestion);
		}
	}

	public void clearCluster() {
		if (this.dQuestions.size() > 0) {
			this.dQuestions.clear();
		}
	}

	public boolean hasQuestion(DQuestion dQuestion) {
		for (DQuestion q : this.dQuestions) {
			if (q.equals(dQuestion)) {
				return true;
			}
		}
		return false;
	}
}