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
	private int id;
	
	@Column(name = "AcceptedAnswerId")
	private int postTypeId;
	
	@Column(name = "PostTypeId")
	private int acceptedAnswerId;
	
	@Column(name = "CreationDate")
	private Date creadionDate;
	
	@Column(name = "ParentId")
	private int parentId;
	
	@Column(name = "Score")
	private int score;
	
	@Column(name = "Body")
	private String body;
	
	@Column(name = "OwnerUserId")
	private int ownerUserId;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "FavoriteCount")
	private int favoriteCount;
	
	@Column(name = "Tags")
	private String tags;
	
	public PostsEntity () {
		
	}

	public int getPostTypeId() {
		return postTypeId;
	}

	public void setPostTypeId(int postTypeId) {
		this.postTypeId = postTypeId;
	}

	public int getAcceptedAnswerId() {
		return acceptedAnswerId;
	}

	public void setAcceptedAnswerId(int acceptedAnswerId) {
		this.acceptedAnswerId = acceptedAnswerId;
	}

	public Date getCreadionDate() {
		return creadionDate;
	}

	public void setCreadionDate(Date creadionDate) {
		this.creadionDate = creadionDate;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getId() {
		return id;
	}
}