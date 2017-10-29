package br.com.ufc.quixada.laurabot.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	private Long id;
	
	private String title;
	
	@Column(name = "post_id")
	private Long postId; 
	
	@ManyToOne
	private Cluster cluster;
	
	@Column(name = "is_medoid")
	private Boolean isMedoid;
	
	@Transient
	private int clusterId = -1;
	
	public Question() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public Boolean getIsMedoid() {
		return isMedoid;
	}

	public void setIsMedoid(Boolean isMedoid) {
		this.isMedoid = isMedoid;
	}

	public int getClusterId() {
		return clusterId;
	}

	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
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
		Question other = (Question) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", postId=" + postId + ", cluster=" + cluster + ", isMedoid="
				+ isMedoid + ", clusterId=" + clusterId + "]";
	}

}