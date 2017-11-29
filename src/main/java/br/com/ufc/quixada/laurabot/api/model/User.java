package br.com.ufc.quixada.laurabot.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "reputation")
	private int reputation;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_access_date")
	private Date lastAccessdate;

	@Column(name = "views")
	private int views;

	@Column(name = "up_votes")
	private int upVotes;

	@Column(name = "down_votes")
	private int downVotes;

	@OneToMany(mappedBy = "user")
	private List<Answer> answers;
	
	@OneToMany(mappedBy = "user")
	private List<JavaQuestion> javaQuestions;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<JavaAnswer> javaAnswers;
	
	public User() {

	}

	public User(Long id) {
		this.id = id;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastAccessdate() {
		return lastAccessdate;
	}

	public void setLastAccessdate(Date lastAccessdate) {
		this.lastAccessdate = lastAccessdate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}

	public int getDownVotes() {
		return downVotes;
	}

	public void setDownVotes(int downVotes) {
		this.downVotes = downVotes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<JavaQuestion> getJavaQuestions() {
		return javaQuestions;
	}

	public void setJavaQuestions(List<JavaQuestion> javaQuestions) {
		this.javaQuestions = javaQuestions;
	}

	public List<JavaAnswer> getJavaAnswers() {
		return javaAnswers;
	}

	public void setJavaAnswers(List<JavaAnswer> javaAnswers) {
		this.javaAnswers = javaAnswers;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
