package com.ambita.service;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Setter
@Service
public class EmailService {

  private Session session;
  private String text;
  private String to;
  private String subject;

  @Autowired
  public void setSession(Session session) {
    this.session = session;
  }

  public void send() {
    MimeMessage message = new MimeMessage(session);
    MimeMessageHelper helper = new MimeMessageHelper(message);

    try {
      helper.setText(text);
      helper.setTo(to);
      helper.setSubject(subject);
      Transport.send(message);
    }
    catch (MessagingException ex) {
      // simply log it and go on...
      System.err.println(ex.getMessage());
    }
  }
}