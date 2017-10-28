package br.com.ufc.quixada.laurabot.clustering.domain;

import java.util.ArrayList;
import java.util.List;

public class Cluster {

	private List<DQuestion> dQuestions;

	private DQuestion centroid;

	private int id;

	public Cluster(int id) {
		this.id = id;
		this.dQuestions = new ArrayList<DQuestion>();
		this.centroid = null;
	}

	public List<DQuestion> getQuestions() {
		return dQuestions;
	}

	public void setQuestions(List<DQuestion> dQuestions) {
		this.dQuestions = dQuestions;
	}

	public DQuestion getCentroid() {
		return centroid;
	}

	public void setCentroid(DQuestion centroid) {
		this.centroid = centroid;
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