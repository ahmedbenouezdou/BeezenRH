package com.beezen.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String roleName;

	public Roles() {
	}

	public Roles(Long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public Roles(String roleName) {
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return this.roleName;
	}

	public void setRole(String role) {
		this.roleName = role;
	}

	@Override
	public String toString() {
		return roleName;
	}

}

