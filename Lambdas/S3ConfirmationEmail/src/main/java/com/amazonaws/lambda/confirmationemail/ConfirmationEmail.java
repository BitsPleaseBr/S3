package com.amazonaws.lambda.confirmationemail;

import javax.print.DocFlavor.URL;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class ConfirmationEmail {
  private String message;

  public void send() {
    // Create the email message
    HtmlEmail email = new HtmlEmail();
    email.setHostName("smtp.googlemail.com");
    email.setSmtpPort(465);
    email.setSSLOnConnect(true);
    email.setAuthenticator(new DefaultAuthenticator("bitspleasebr", "b1tspl34s3"));
    try {
      email.addTo(new String[] {"diogodklein@gmail.com", "guhillesheim@gmail.com",
          "gbtotti@live.com", "arianarbarba@gmail.com"});
      email.setFrom("bitspleasebr@gmail.com");
    } catch (EmailException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    email.setSubject("HTML TestMail");

    // embed the image and get the content id
    URL url;
    try {
      url = new URL("http://teste.mk4avhzpsj.sa-east-1.elasticbeanstalk.com/_img/icon.png");
      String cid = email.embed(url.toString(), "Nossa Logo");
      // set the html message
      email.setHtmlMsg("<html>Nossa logo - <img src=\"cid:" + cid + "\"></html>");

      // set the alternative message
      email.setTextMsg("Your email client does not support HTML messages");

      // send the email
      email.send();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  ConfirmationEmail(String message) {
    this.message = message;
  }
}
