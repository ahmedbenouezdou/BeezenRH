package com.beezen.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.beezen.domain.Utilisateurs;


public interface UtilisateursRepo extends CrudRepository<Utilisateurs, Long> {

	Utilisateurs findByEmail(String email);
	
	public List<Utilisateurs> findAllByOrderByEmail();

	public Optional<Utilisateurs> findById(Long id);

	public Utilisateurs findByUsername(String username);
}