package com.amazonaws.lambda.confirmationemail;

import java.io.File;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ConfirmationEmail {
  private final String fromAdress = System.getenv("fromAdress");
  private final String emailUser = System.getenv("emailUser");
  private final String emailPassword = System.getenv("emailPassword");
  private final String smtpHost = System.getenv("smtpHost");
  private final Integer smtpPort = Integer.valueOf(System.getenv("smtpPort"));
  private final String subject = System.getenv("emailSubject");
  private final String baseURL = System.getenv("confirmationURL");
  private final String URLPattern = baseURL + "?token=%s"; 
  private MessageParser parser;

  public void send() {
    // Enviar o email
    HtmlEmail email = new HtmlEmail();
    email.setHostName(smtpHost);
    email.setSmtpPort(smtpPort);
    email.setSSLOnConnect(true);
    email.setAuthenticator(new DefaultAuthenticator(emailUser, emailPassword));
    try {
      email.addTo(parser.getEmail());
      email.setFrom(fromAdress);
    } catch (EmailException e) {
      e.printStackTrace();
    }
    email.setSubject(subject);

    try {
      // Configura o html do email
      File template = new File("template/EmailTemplate.html");
      Document doc = Jsoup.parse(template, "UTF-8","");

      // Gera link de confirmação
      String confirmationUrl = String.format(URLPattern, parser.getToken());
      doc.select("name").first().text(parser.getNome());
      doc.select("link").first().text(confirmationUrl);
      
      email.setHtmlMsg(doc.toString());
      // Envia o e-mail
      email.send();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static ConfirmationEmail build(String message) {
    ConfirmationEmail email = new ConfirmationEmail();
    email.parser = new MessageParser(message);
    return email;
  }

  private ConfirmationEmail() {
  }
}
