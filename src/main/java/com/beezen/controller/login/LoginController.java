package com.beezen.controller.login;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.beezen.domain.Utilisateurs;
import com.beezen.exeption.CustomException;
import com.beezen.exeption.NotFoundExeption;
import com.beezen.service.IEmailService;
import com.beezen.service.IUtilisateursService;

import javassist.NotFoundException;


@CrossOrigin
@RestController
@RequestMapping
public class LoginController {

	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${basic.message}")
	private String message;
	
	@Autowired
	private IUtilisateursService utilisateursService;
	
	@Autowired
	private IEmailService emailService;
	
	@PreAuthorize("hasAnyAuthority('Admin')")
	@RequestMapping({ "/api/testconnexion" })
	@ResponseBody
	public Boolean testConnexion() {
		// System.out.println("--- TEST DE CONNEXION ---");
		return Boolean.TRUE;

	}

	@RequestMapping({ "/api/login" })
	@ResponseBody
	public Boolean login() {
		// System.out.println("--- TEST DE CONNEXION ---");
		return Boolean.TRUE;
	}
	
	@RequestMapping({ "/sendtestmail" })
	@ResponseBody
	public void sendtestmail() throws MessagingException, CustomException {
		// System.out.println("--- TEST DE CONNEXION ---");
		Utilisateurs u = utilisateursService.getUtilisateurParEmail("khadija.sejjil@gmail.com");
		//emailService.sendTestEmail(u);
		emailService.sendSimpleMessage(u);
	}

	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public String index() {
		return "index";
	}

	@ResponseStatus(value= HttpStatus.NOT_FOUND)
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String handleNotFound() {
        return "default";
    }

@GetMapping("/welcome")
public String retrieveWelcomeMessage() {
	// Complex Method
	return welcomeMessage+message;
}





/****/

@PutMapping(value = "/forgotpassword")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void forgotPassword(@RequestBody String email)
		throws MessagingException, CustomException, NotFoundException {
	String code;
	String url;
	Utilisateurs user = utilisateursService.getUtilisateurParEmail(email);
	if (user == null) {
		System.out.println("utilisateur non trouvé"+email);
		throw new CustomException("message.info.utilisateurnontrouvee");
	} else {
		code = UUID.randomUUID().toString();
		for (int i = 1; i <= 10; i++) {
			System.out.println(UUID.randomUUID().toString().length());
		}
		user.setCodereset(code);
		user.setDatereset(new Date());
		user = utilisateursService.saveUtilisateur(user);
		url = "http://localhost:4200/pwdreset/"+ user.getCodereset().toString();
	    emailService.sendLinkEmail(user, url);
	}
}

@PutMapping(value = "/verifycode")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void verifyCode(@RequestBody String code, HttpServletRequest request)
		throws CustomException,NotFoundExeption {
	Utilisateurs user = utilisateursService.getUtilisateurParCode(code);
	if (user == null) {
		System.out.println("user not found");
		throw new NotFoundExeption();
	} else {
		Date date = new Date(user.getDatereset().getTime());
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MINUTE, 15);
		Date expiryDate = now.getTime();
		if (user.getCodereset().equals(code) && new Date().before(expiryDate)) {
			
		} else if (!(user.getCodereset().equals(code)) && new Date().before(expiryDate)) {
			System.out.println("codeinvalide");
			throw new CustomException("message.erreur.reset.codeinvalide");
		} else {
			System.out.println("codeexpired");
			throw new CustomException("message.erreur.reset.codeexpired");
		}
	}
}

@PutMapping(value = "/resetpassword")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void resetPassword(@RequestBody Map<String, String> json) throws CustomException,NotFoundExeption {

			Utilisateurs user = utilisateursService.getUtilisateurParCode(json.get("code"));
			if (user == null) {
				System.out.println("codeinvalide");
				throw new CustomException("message.erreur.reset.codeinvalide");
			} else {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				user.setPassword(encoder.encode(json.get("newpwd")));
				user = utilisateursService.saveUtilisateur(user);
			}
}







}