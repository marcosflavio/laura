package br.com.ufc.quixada.laurabot.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cluster {
	
	@Id
	private Long id;

	@OneToMany(mappedBy = "cluster")
	private List<Question> questions;
	
	public Cluster() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
