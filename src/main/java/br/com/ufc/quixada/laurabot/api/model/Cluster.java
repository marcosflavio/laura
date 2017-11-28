package br.com.ufc.quixada.laurabot.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clusters")
public class Cluster {
	
	@Id
	private Long id;

	private String name;
	
	@OneToMany(mappedBy = "cluster")
	private List<JavaQuestion> javaQuestions;
	
	public Cluster() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<JavaQuestion> getJavaQuestions() {
		return javaQuestions;
	}

	public void setJavaQuestions(List<JavaQuestion> javaQuestions) {
		this.javaQuestions = javaQuestions;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
