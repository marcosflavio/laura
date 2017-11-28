package br.com.ufc.quixada.laurabot.metric.model;

public class LauraAnswerMetric {

	private Double acceptedAnswerValue;

	private Double bodyValue;

	private Double scoreValue;

	private Double favoriteCountValue;

	private Double reputationValue;

	private Double viewsValue;

	private Double upVotesValue;

	private Double downVotesValue;

	private Double creationDateValue;

	private Double answersCountValue;

	public LauraAnswerMetric() {

	}

	public Double getAcceptedAnswerValue() {
		return acceptedAnswerValue;
	}

	public void setAcceptedAnswerValue(Double acceptedAnswerValue) {
		this.acceptedAnswerValue = acceptedAnswerValue;
	}

	public Double getBodyValue() {
		return bodyValue;
	}

	public void setBodyValue(Double bodyValue) {
		this.bodyValue = bodyValue;
	}

	public Double getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(Double scoreValue) {
		this.scoreValue = scoreValue;
	}

	public Double getFavoriteCountValue() {
		return favoriteCountValue;
	}

	public void setFavoriteCountValue(Double favoriteCountValue) {
		this.favoriteCountValue = favoriteCountValue;
	}

	public Double getReputationValue() {
		return reputationValue;
	}

	public void setReputationValue(Double reputationValue) {
		this.reputationValue = reputationValue;
	}

	public Double getViewsValue() {
		return viewsValue;
	}

	public void setViewsValue(Double viewsValue) {
		this.viewsValue = viewsValue;
	}

	public Double getUpVotesValue() {
		return upVotesValue;
	}

	public void setUpVotesValue(Double upVotesValue) {
		this.upVotesValue = upVotesValue;
	}

	public Double getDownVotesValue() {
		return downVotesValue;
	}

	public void setDownVotesValue(Double downVotesValue) {
		this.downVotesValue = downVotesValue;
	}

	public Double getCreationDateValue() {
		return creationDateValue;
	}

	public void setCreationDateValue(Double creationDateValue) {
		this.creationDateValue = creationDateValue;
	}

	public Double getAnswersCountValue() {
		return answersCountValue;
	}

	public void setAnswersCountValue(Double answersCountValue) {
		this.answersCountValue = answersCountValue;
	}

	public Double getRankValue() {
		return ((2 * acceptedAnswerValue) + (2 + bodyValue) + scoreValue + favoriteCountValue + reputationValue
				+ viewsValue + upVotesValue + downVotesValue + creationDateValue + answersCountValue) / 12;
	}
}
