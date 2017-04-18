package com.ambita.config;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

  @Value("${email.from}")
  private String emailFrom;
  @Value("${email.password}")
  private String emailPassword;
  @Value("${email.host}")
  private String emailHost;
  @Value("${email.port}")
  private String emailPort;

  @Bean
  public Session createEmailSession() {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", emailHost);
    props.put("mail.smtp.port", emailPort);

    return Session.getInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(emailFrom, emailPassword);
          }
        });
  }
}