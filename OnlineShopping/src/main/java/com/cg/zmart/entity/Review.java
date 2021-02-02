package com.cg.zmart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEWS")
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String comments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Review(String comments) {
		super();
		this.comments = comments;
	}

	public Review() {
	}
}
