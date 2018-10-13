package com.beezen.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateurs", schema = "config")
public class Utilisateurs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String email;
	private String mdp;
	private String numtel;
	private Integer codereset;
	private Date datereset;
	private String nom;
	private String prenom;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "utilisateurs_roles", joinColumns = @JoinColumn(name = "utilisateurid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<Roles> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getCodereset() {
		return codereset;
	}

	public void setCodereset(Integer codereset) {
		this.codereset = codereset;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Integer getCodeReset() {
		return codereset;
	}

	public void setReset(Integer codereset) {
		this.codereset = codereset;
	}

	public Date getDatereset() {
		return datereset;
	}

	public void setDatereset(Date datereset) {
		this.datereset = datereset;
	}

	public String getNumtel() {
		return numtel;
	}

	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


}

