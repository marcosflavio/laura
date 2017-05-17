package br.com.ufc.quixada.laurabot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class UsersEntity {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "reputation")
	private int reputation;
	
	@Column(name = "creationDate")
	private Date creationDate;
	
	@Column(name = "lastAccessdate")
	private Date lastAccessdate;
	
	@Column(name = "views")
	private int views;
	
	@Column(name = "upVotes")
	private int upVotes;
	
	@Column(name = "downVotes")
	private int downVotes;
	
	@Column(name = "accountId")
	private int accountId;
	
	public UsersEntity () {
		
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

	public int getId() {
		return id;
	}

	public int getAccountId() {
		return accountId;
	}
}
