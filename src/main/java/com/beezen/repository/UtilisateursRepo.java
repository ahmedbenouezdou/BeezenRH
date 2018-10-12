package com.beezen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.beezen.domain.Utilisateurs;


public interface UtilisateursRepo extends CrudRepository<Utilisateurs, Long> {

	Utilisateurs findByEmail(String email);


	@Query(value = "SELECT u.* FROM  utilisateurs as u EXCEPT (SELECT u.* FROM  utilisateurs as u JOIN utilisateurs_roles as ur ON u.compteur = ur.compteur JOIN roles as r ON ur.roleid = r.roleid WHERE r.role like  'Admin') ORDER BY Email", nativeQuery = true)
	List<Utilisateurs> getUtilisateursWithoutAdmin();

	
	public List<Utilisateurs> findAllByOrderByEmail();

	public Optional<Utilisateurs> findById(Long id);
}