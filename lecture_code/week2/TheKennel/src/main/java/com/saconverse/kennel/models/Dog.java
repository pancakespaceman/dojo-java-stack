package com.saconverse.kennel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dogs")
public class Dog {
	// ========== Primary Key ===================

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    // ========== Member Variables ==============

    @Size(min = 2, message = "Not Enough! Do Better!")
    private String name;
    
    @NotNull(message = "Must enter in an age")
    @Min(0)
    private Integer age;
    
    @Size(min = 2, message = "Must enter hair color")
    private String hairColor;

    // ========== Data Creation Trackers ========

    @Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

    // ========== Constructors ===================

	public Dog() {}

    public Dog(@Size(min = 2) String name, @Min(0) Integer age, @Size(min = 2) String hairColor) {
		this.name = name;
		this.age = age;
		this.hairColor = hairColor;
	}

	// ========== Data Creation Event ===========

    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
    // ========== Getters and Setters ===========

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
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
}