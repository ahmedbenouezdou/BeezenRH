package com.beezen.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.beezen.domain.Utilisateurs;
import com.beezen.exeption.CustomException;
import com.beezen.service.IUtilisateursService;

@CrossOrigin
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateursController {

	@Autowired
	private IUtilisateursService utilisateursService;



	@GetMapping
	public Boolean getUtilisateurByEmail(String email) {
		return utilisateursService.IsUtilisateurs(email);
	}

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

	// @PreAuthorize("hasAnyAuthority('Admin')")
//	@GetMapping(value = "/getId")
//	public Long getUtilisateurId(String login) {
//		return utilisateursService.getUtilisateurId(login);
//	}

	// @PreAuthorize("hasAnyAuthority('Admin')")
	@GetMapping(value = "/getAll")
	public List<Utilisateurs> getAllUtilisateurs() {
		return utilisateursService.getAllUtilisateurs();
	}

	@GetMapping(value = "/getUtilisateurParId")
	public Utilisateurs getUtilisateursParId(@RequestParam(name = "id") Long id) {

		return utilisateursService.getUtilisateurParId(id);
	}

    @PreAuthorize("hasAnyAuthority('Admin')")
	@RequestMapping(value = "/getUtilisateurParEmail")
	public Utilisateurs getUtilisateursParEmail(@RequestParam(name = "email") String email) {

		return utilisateursService.getUtilisateurParEmail(email);
	}

	@RequestMapping(value = "/getUtilisateurParUsername")
	public Utilisateurs getUtilisateursParLogin(@RequestParam(name = "username") String username) {

		return utilisateursService.getUtilisateurParUsername(username);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/authentificate")
	public Map<String, Boolean> authenticate(@RequestBody Utilisateurs user) {

		Utilisateurs utilisateur = utilisateursService.getUtilisateurParUsername(user.getUsername());

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if (utilisateur != null && encoder.matches(user.getPassword(), utilisateur.getPassword()))
			return Collections.singletonMap("success", true);
		return Collections.singletonMap("success", false);

	}

	@PostMapping
	public Utilisateurs saveUtilisateur(@RequestBody Utilisateurs u) {

		Utilisateurs user = utilisateursService.getUtilisateurParId(u.getId());

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if (user == null || !user.getPassword().equals(u.getPassword())) {
			u.setPassword(encoder.encode(u.getPassword()));
		}

		return utilisateursService.saveUtilisateur(u);
	}

	@DeleteMapping
	public void deleteUtilisateur(Long id) throws CustomException {
		if (utilisateursService.getUtilisateurParEmail(SecurityContextHolder.getContext().getAuthentication().getName())
				.getId() == id) {
			throw new CustomException("message.erreur.self.suppression");
		}
		utilisateursService.deleteUtilisateur(id);
	}

}
