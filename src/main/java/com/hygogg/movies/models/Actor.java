package com.hygogg.movies.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="actresses")
public class Actor {

	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min = 2, message = "Name must be 2 characters or longer")
	private String name;
	
	private Date createdAt;
	private Date updatedAt;
	
	public Actor() {
	}
	
	public Actor(String name) {
		this.name = name;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    protected void onCreate(){
		this.setUpdatedAt(new Date());
		this.setCreatedAt(new Date());
    }

    @PreUpdate
    protected void onUpdate(){
    	this.setUpdatedAt(new Date());
    }
	
}
