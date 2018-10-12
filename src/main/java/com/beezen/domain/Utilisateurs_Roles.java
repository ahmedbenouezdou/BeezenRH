package com.beezen.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateurs_roles", schema = "config")
public class Utilisateurs_Roles implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private Long utilisateurId;
	@Id
	private Long roleId;
	

	public Long getUtilisateurId() {
		return utilisateurId;
	}
	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}



}
