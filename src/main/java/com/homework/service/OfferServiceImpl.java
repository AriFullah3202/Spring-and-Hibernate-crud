package com.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.homework.dao.OfferDaoImpl;
import com.homework.entity.Offer;
@Service
public class OfferServiceImpl implements OfferService {
	@Autowired
    private OfferDaoImpl offerDaoImpl;
	@Autowired
	private JavaMailSender javaMailSender;

	public void addOffer(Offer offer) {
		sendEmail();
		
	  offerDaoImpl.addOffer(offer);
		
	}

	private void sendEmail() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("marifullaah@gmail.com");
		simpleMailMessage.setSubject("Add and Update");
		simpleMailMessage.setText("New user has been added , Thankyou");
		javaMailSender.send(simpleMailMessage);
		
	}

	public void update(Offer offer) {
		sendEmail();
		offerDaoImpl.update(offer);
	}

}
