package br.com.ufc.quixada.laurabot.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clusters")
public class Cluster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;

	private String name;
	
	@OneToMany(mappedBy = "cluster")
	private List<JavaQuestion> javaQuestions;
	
	
	@OneToOne
	private JavaQuestion javaQuestion;
	
	public Cluster() {
		this.javaQuestions = new ArrayList<JavaQuestion>();
		this.javaQuestion = null;
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
	
	public void addQuestion(JavaQuestion dQuestion) {
		if (this.javaQuestions != null) {
			this.javaQuestions.add(dQuestion);
		}
	}

	public void clearCluster() {
		if (this.javaQuestions.size() > 0) {
			this.javaQuestions.clear();
		}
	}

	public boolean hasQuestion(JavaQuestion questionReceived) {
		return this.javaQuestions.contains(questionReceived);
	}

	public JavaQuestion getMedoid() {
		return javaQuestion;
	}

	public void setMedoid(JavaQuestion medoid) {
		this.javaQuestion = medoid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cluster other = (Cluster) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
