package projectSR03.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailManager {
	
	public static void SendMessage(String to, String content, String subject) {
	      // Get system properties

		final String smtpServer = "smtp.gmail.com";
		final String userAccount = "vkeller05@gmail.com"; // Sender Account.
		final String password = "aZxbg909"; // Password -> Application Specific Password.
		final String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
		final String smtpPort = "587";
		final String PORT = "465";

		final Properties props = new Properties();
		props.put("mail.smtp.host", smtpServer);
		props.put("mail.smtp.user", userAccount);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.debug", "false");
		props.put("mail.smtp.socketFactory.port", PORT);
		props.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getInstance(props,
		new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(userAccount, password);
		    }
		});
		
		try {
		MimeMessage mimeMessage = new MimeMessage(session);
		final Address toAddress = new InternetAddress(to); // toAddress
		final Address fromAddress = new InternetAddress(userAccount);
		mimeMessage.setContent(content, "text/html; charset=UTF-8");
		mimeMessage.setFrom(fromAddress);
		mimeMessage.setRecipient(javax.mail.Message.RecipientType.TO, toAddress);
		mimeMessage.setSubject(subject);
		Transport transport = session.getTransport("smtp");
		transport.connect(smtpServer, userAccount, password);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		} catch(Exception e) {
			System.out.println("Erreur " + e.getMessage());
		}
	}
	
}
