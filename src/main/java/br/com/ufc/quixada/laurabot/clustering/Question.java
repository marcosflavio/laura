package br.com.ufc.quixada.laurabot.clustering;

public class Question {

	private String title;
	private Long id;
	private int clusterId = -1;

	public Question(String title, Long id) {
		this.title = title;
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setClusterId(int n) {
		this.clusterId = n;
	}

	public int getClusterId() {
		return this.clusterId;
	}

	@Override
	public String toString() {
		return "Question [title=" + title + ", id=" + id + ", Cluster=" + clusterId + "]";
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
}
