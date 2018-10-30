package com.beezen.service;

import java.util.List;

import com.beezen.domain.Utilisateurs;


public interface IUtilisateursService {
	
	public boolean IsUtilisateurs(String email);

	public Utilisateurs getUtilisateurParEmail(String email);

	public List<Utilisateurs> getAllUtilisateurs();

	public Utilisateurs getUtilisateurParUsername(String username);

	public Utilisateurs saveUtilisateur(Utilisateurs u);

	public void deleteUtilisateur(Long id);

	public Utilisateurs getUtilisateurParId(Long id);

	public Long getUtilisateurId(String email);

}
