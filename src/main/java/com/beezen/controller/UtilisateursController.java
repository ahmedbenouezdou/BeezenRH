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
	@RequestMapping("/api/utilisateurs")
	public class UtilisateursController {

		@Autowired
		private IUtilisateursService utilisateursService;

		@GetMapping
		public Boolean getUtilisateurByEmail(String email) {
			return utilisateursService.IsUtilisateurs(email);
		}

		@PreAuthorize("hasAnyAuthority('Admin')")
		@GetMapping(value = "/getId")
		public Long getUtilisateurId(String login) {
			return utilisateursService.getUtilisateurId(login);
		}

		@PreAuthorize("hasAnyAuthority('Admin')")
		@GetMapping(value = "/getAll")
		public List<Utilisateurs> getAllUtilisateurs() {
			return utilisateursService.getAllUtilisateurs();
		}

		@PreAuthorize("hasAnyAuthority('Admin')")
		@GetMapping(value = "/getUtilisateurs")
		public List<Utilisateurs> getUtilisateursWithoutAdmin() {
			return utilisateursService.getUtilisateursWithoutAdmin();
		}

		@PreAuthorize("hasAnyAuthority('Admin')")
		@RequestMapping(value = "/getUtilisateurParEmail")
		public Utilisateurs getUtilisateursParEmail(@RequestParam(name = "email") String email) {

			return utilisateursService.getUtilisateurParEmail(email);
		}

		@RequestMapping(method = RequestMethod.POST, value = "/authentificate")
		public Map<String, Boolean> authenticate(@RequestBody Utilisateurs user) {

			Utilisateurs utilisateur = utilisateursService.getUtilisateurParEmail(user.getEmail());

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (utilisateur != null && encoder.matches(user.getMdp(), utilisateur.getMdp()))
				return Collections.singletonMap("success", true);
			return Collections.singletonMap("success", false);

		}

		@PreAuthorize("hasAnyAuthority('Admin')")
		@PostMapping
		public Utilisateurs saveUtilisateur(@RequestBody Utilisateurs u) {

			Utilisateurs user = utilisateursService.getUtilisateurParId(u.getId());

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (user == null || !user.getMdp().equals(u.getMdp())) {
				u.setMdp(encoder.encode(u.getMdp()));
			}

			return utilisateursService.saveUtilisateur(u);
		}

		@PreAuthorize("hasAnyAuthority('Admin')")
		@DeleteMapping
		public void deleteUtilisateur(Long id) throws CustomException {
			if (utilisateursService.getUtilisateurParEmail(SecurityContextHolder.getContext().getAuthentication().getName())
					.getId() == id) {
				throw new CustomException("message.erreur.self.suppression");
			}
			utilisateursService.deleteUtilisateur(id);
		}


	}
