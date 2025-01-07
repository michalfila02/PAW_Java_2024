package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String email;

	@Column(name="email_verified_at")
	private Timestamp emailVerifiedAt;

	private BigInteger id;

	private String name;

	private String password;

	@Column(name="remember_token")
	private String rememberToken;

	@Column(name="stworzone_przez")
	private String stworzonePrzez;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="zmienione_przez")
	private String zmienionePrzez;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	public User() {
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getEmailVerifiedAt() {
		return this.emailVerifiedAt;
	}

	public void setEmailVerifiedAt(Timestamp emailVerifiedAt) {
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRememberToken() {
		return this.rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	public String getStworzonePrzez() {
		return this.stworzonePrzez;
	}

	public void setStworzonePrzez(String stworzonePrzez) {
		this.stworzonePrzez = stworzonePrzez;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getZmienionePrzez() {
		return this.zmienionePrzez;
	}

	public void setZmienionePrzez(String zmienionePrzez) {
		this.zmienionePrzez = zmienionePrzez;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}