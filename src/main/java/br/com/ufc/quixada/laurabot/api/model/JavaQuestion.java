package br.com.ufc.quixada.laurabot.api.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "java_questions")
public class JavaQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
	private String title;
	
	@OneToOne
	private Post post;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	private Cluster cluster;
	
	@Column(name = "is_medoid")
	private Boolean isMedoid;
	
	@Transient
	private int clusterId = -1;
	
	@OneToOne
	private JavaAnswer javaAnswer;
	
	@OneToMany(mappedBy = "javaQuestion", fetch = FetchType.EAGER)
	private List<JavaAnswer> javaAnswers;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	public JavaQuestion() {
		
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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
	
	public List<JavaAnswer> getJavaAnswers() {
		return javaAnswers;
	}

	public void setJavaAnswers(List<JavaAnswer> javaAnswers) {
		this.javaAnswers = javaAnswers;
	}

	public JavaAnswer getAcceptedAnswer() {
		return javaAnswer;
	}

	public void setAcceptedAnswer(JavaAnswer acceptedAnswer) {
		this.javaAnswer = acceptedAnswer;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clusterId;
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
		JavaQuestion other = (JavaQuestion) obj;
		if (clusterId != other.clusterId)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
