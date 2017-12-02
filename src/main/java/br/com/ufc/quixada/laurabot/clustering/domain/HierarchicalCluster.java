package br.com.ufc.quixada.laurabot.clustering.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;

@Entity
public class HierarchicalCluster {

	@Id
	private Long id;

	private String name;
	
	@OneToOne
	private HierarchicalCluster parent;
	
	@OneToOne
	private HierarchicalCluster left;
	
	@OneToOne
	private HierarchicalCluster right;
	
	private Double distance;
	
	@OneToOne
	private JavaQuestion javaQuestion;
	
	public HierarchicalCluster() {
		
	}
		
	public HierarchicalCluster(JavaQuestion javaQuestion) {
		this.javaQuestion = javaQuestion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HierarchicalCluster getParent() {
		return parent;
	}

	public void setParent(HierarchicalCluster parent) {
		this.parent = parent;
	}

	public HierarchicalCluster getLeft() {
		return left;
	}

	public void setLeft(HierarchicalCluster left) {
		this.left = left;
	}

	public HierarchicalCluster getRight() {
		return right;
	}

	public void setRight(HierarchicalCluster right) {
		this.right = right;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public JavaQuestion getJavaQuestion() {
		return javaQuestion;
	}

	public void setJavaQuestion(JavaQuestion javaQuestion) {
		this.javaQuestion = javaQuestion;
	}
	
	public HierarchicalCluster merge(HierarchicalCluster cluster, Double distance) {
		HierarchicalCluster parent = new HierarchicalCluster();
		parent.setLeft(this);
		this.setParent(parent);
		parent.setRight(cluster);
		cluster.setParent(parent);
		JavaQuestion javaQuestion = new JavaQuestion("");
		parent.setJavaQuestion(javaQuestion);
		parent.setDistance(distance);
		
		return parent;
	}
	
	@Override
	public String toString() {
		return this.javaQuestion.getTitle();
	}
}
