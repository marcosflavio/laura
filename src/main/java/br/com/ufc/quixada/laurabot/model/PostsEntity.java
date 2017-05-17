package br.com.ufc.quixada.laurabot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Posts")
public class PostsEntity {

	@Id
	@Column(name = "Id")
	private Long Id;

	@Column(name = "PostTypeId")
	private Long PostTypeId;

	@Column(name = "AcceptedAnswerId")
	private Long AcceptedAnswerId;

	@Column(name = "CreationDate")
	private Date CreationDate;

	@Column(name = "ParentId")
	private Long ParentId;

	@Column(name = "Score")
	private Long Score;

	@Column(name = "Body")
	private String Body;

	@Column(name = "OwnerUserId")
	private Long OwnerUserId;

	@Column(name = "Title")
	private String Title;

	@Column(name = "FavoriteCount")
	private Long FavoriteCount;

	@Column(name = "Tags")
	private String Tags;

	public PostsEntity() {

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getPostTypeId() {
		return PostTypeId;
	}

	public void setPostTypeId(Long postTypeId) {
		PostTypeId = postTypeId;
	}

	public Long getAcceptedAnswerId() {
		return AcceptedAnswerId;
	}

	public void setAcceptedAnswerId(Long acceptedAnswerId) {
		AcceptedAnswerId = acceptedAnswerId;
	}

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}

	public Long getParentId() {
		return ParentId;
	}

	public void setParentId(Long parentId) {
		ParentId = parentId;
	}

	public Long getScore() {
		return Score;
	}

	public void setScore(Long score) {
		Score = score;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	public Long getOwnerUserId() {
		return OwnerUserId;
	}

	public void setOwnerUserId(Long ownerUserId) {
		OwnerUserId = ownerUserId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Long getFavoriteCount() {
		return FavoriteCount;
	}

	public void setFavoriteCount(Long favoriteCount) {
		FavoriteCount = favoriteCount;
	}

	public String getTags() {
		return Tags;
	}

	public void setTags(String tags) {
		Tags = tags;
	}
}