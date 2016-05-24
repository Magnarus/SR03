package projectSR03.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailManager {

	private static String from = "vincent.keller@etu.utc.fr";
	private static String host = "smtps.utc.fr";
	private static String port = "465";
			
	public static void SendMessage(String to, String content, String subject) {
	      // Get system properties
	      Properties properties = System.getProperties();
	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.port", port);
	      properties.setProperty("mail.smtp.auth", "true");
	     
	      Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	            	// REMPLACEZ VOS ID
	                return new PasswordAuthentication("XXXX", "XXXX@K");
	            }
	        };
	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties, auth);
	      
	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));
	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         // Set Subject: header field
	         message.setSubject(subject);
	         // Now set the actual message
	         message.setText(content);
	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
	
}
