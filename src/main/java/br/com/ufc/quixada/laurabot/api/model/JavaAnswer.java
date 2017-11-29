package br.com.ufc.quixada.laurabot.api.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "java_answers")
public class JavaAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	private String body;

	@OneToOne
	private Post post;

	private Double rankValue;

	private Long score;

	private Date creationDate;

	private Long favoriteCount;

	private String tags;

	@ManyToOne
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
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

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(Long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
