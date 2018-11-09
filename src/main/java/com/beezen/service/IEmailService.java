package com.beezen.service;

import javax.mail.MessagingException;

import com.beezen.domain.Utilisateurs;
import com.beezen.exeption.CustomException;


public interface IEmailService {

	void sendTestEmail(Utilisateurs u) throws MessagingException, CustomException;
	
	void sendLinkEmail(Utilisateurs u,String url) throws MessagingException, CustomException;

	void sendSimpleMessage(Utilisateurs u)throws MessagingException;
}
