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
	private Long utilisateurid;
	@Id
	private Long roleid;
	

	public Long getUtilisateurId() {
		return utilisateurid;
	}
	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurid = utilisateurId;
	}
	public Long getRoleId() {
		return roleid;
	}
	public void setRoleId(Long roleId) {
		this.roleid = roleId;
	}



}
