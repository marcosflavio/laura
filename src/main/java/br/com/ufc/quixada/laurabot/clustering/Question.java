package br.com.ufc.quixada.laurabot.clustering;

public class Question {

	private String title;
	private int id;
	private int clusterId = -1;

	public Question(String title, int id) {
		this.title = title;
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
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
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
