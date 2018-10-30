package com.beezen.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "email")
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String adressesmtp;
	private String expediteur;
	private int port;
	private String username;
	private String password;
	private int securite;
	private String ehlohost;
	private boolean debug;
	private String administrateur1;
	private String administrateur2;
	private String administrateur3;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdressesmtp() {
		return adressesmtp;
	}

	public void setAdressesmtp(String adressesmtp) {
		this.adressesmtp = adressesmtp;
	}

	public String getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSecurite() {
		return securite;
	}

	public void setSecurite(int securite) {
		this.securite = securite;
	}

	public String getEhlohost() {
		return ehlohost;
	}

	public void setEhlohost(String ehlohost) {
		this.ehlohost = ehlohost;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public String getAdministrateur1() {
		return administrateur1;
	}

	public void setAdministrateur1(String administrateur1) {
		this.administrateur1 = administrateur1;
	}

	public String getAdministrateur2() {
		return administrateur2;
	}

	public void setAdministrateur2(String administrateur2) {
		this.administrateur2 = administrateur2;
	}

	public String getAdministrateur3() {
		return administrateur3;
	}

	public void setAdministrateur3(String administrateur3) {
		this.administrateur3 = administrateur3;
	}

	@Transient
	@JsonIgnore
	public boolean isParametrageMinimalValide() {
		return (this.expediteur != null && this.adressesmtp != null);
	}
}
