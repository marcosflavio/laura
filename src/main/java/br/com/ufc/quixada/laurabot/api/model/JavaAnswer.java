package br.com.ufc.quixada.laurabot.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "java_answers")
public class JavaAnswer {

	@Id
	private Long id;
	
	private String body;
	
	@Column(name = "post_id")
	private Long postId;
	
	private Double rankValue;

	@ManyToOne
	private JavaQuestion javaQuestion;
	
	public JavaAnswer() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Double getRankValue() {
		return rankValue;
	}

	public void setRankValue(Double rankValue) {
		this.rankValue = rankValue;
	}

	public JavaQuestion getJavaQuestion() {
		return javaQuestion;
	}

	public void setJavaQuestion(JavaQuestion javaQuestion) {
		this.javaQuestion = javaQuestion;
	}
	
}
