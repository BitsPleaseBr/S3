package com.amazonaws.lambda.confirmationemail;

import javax.print.DocFlavor.URL;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

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
    // Create the email message
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
      // set the html message
      email.setHtmlMsg("<html></html>");

      // set the alternative message
      email.setTextMsg("Tinha uma imagem legal aqui se você abrisse esse email em html =(");

      // gera link de confirmação
      String confirmationUrl = String.format(URLPattern, parser.getToken());
      // send the email
      email.send();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  ConfirmationEmail(String message) {
    parser = new MessageParser(message);
  }
}
