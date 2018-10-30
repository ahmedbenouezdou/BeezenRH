package com.beezen.domain;

public class Token {
	private String message;
	private String token;
	private Long id;
	private String nom;
	private String prenom;
	private String role;

	public Token() {
	}



	public Token(String message, String token, Long id, String nom, String prenom, String role) {
		super();
		this.message = message;
		this.token = token;
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
