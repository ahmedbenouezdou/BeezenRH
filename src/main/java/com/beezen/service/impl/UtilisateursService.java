package com.beezen.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beezen.domain.Utilisateurs;
import com.beezen.repository.AddressRepo;
import com.beezen.repository.UtilisateursRepo;
import com.beezen.service.IUtilisateursService;

@Service
public class UtilisateursService implements IUtilisateursService {

	@Autowired
	private UtilisateursRepo repo;

	@Autowired
	private AddressRepo repoAddress;
	
	@Override
	public boolean IsUtilisateurs(String email) {
		Utilisateurs user = repo.findByEmail(email);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Utilisateurs getUtilisateurParUsername(String username) {

		return repo.findByUsername(username);
	}
	
	@Override
	public List<Utilisateurs> getAllUtilisateurs() {
		return (List<Utilisateurs>) repo.findAllByOrderByEmail();
	}

	@Override
	public Utilisateurs saveUtilisateur(Utilisateurs u) {
		if (u.getEmail() != null) {
			if (u.getEmail().isEmpty()) {
				u.setEmail(null);
			}
		}
		repoAddress.save(u.getAddress());
		return repo.save(u);
	}

	@Override
	public void deleteUtilisateur(Long id) {
		repo.deleteById(id);
	}

//	@Override
//	public List<Utilisateurs> getUtilisateursWithoutAdmin() {
//		return repo.getUtilisateursWithoutAdmin();
//	}

	
	
	@Override
	public Long getUtilisateurId(String username) {
		return getUtilisateurParUsername(username).getId();
	}

	@Override
	public Utilisateurs getUtilisateurParId(Long id) {
		Optional<Utilisateurs> optional = repo.findById(id);
		Utilisateurs user = optional.get();
		return user;
	}

	@Override
	public Utilisateurs getUtilisateurParEmail(String email) {
		Utilisateurs user = repo.findByEmail(email);
		return  user;
	}

	@Override
	public Utilisateurs getUtilisateurParCode(String code) {
	 return repo.findBycodereset(code);
	}


}
