// https://developers.google.com/gmail/api/guides/sending
// https://netcorecloud.com/tutorials/send-email-in-java-using-gmail-smtp/
package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SendMail {
    private static final Logger logger = LoggerFactory.getLogger(SendMail.class);
    public static String send(String subject, String msg) {
        // Assuming you are sending email from through gmail smtp
        String host = "smtp.gmail.com";

        // Get system properties
        try {
            InputStream input = new FileInputStream("system.properties");
            Properties properties = System.getProperties();
            properties.load(input);

            // Setup mail server
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");
            String from = properties.getProperty("mail.smtp.from");
            String password = properties.getProperty("mail.smtp.password");
            System.out.println("PASSWORD: " + password);
            String to = properties.getProperty("mail.smtp.to");
            logger.debug("Properties: " + properties.toString());
            // Get the Session object.// and pass username and password
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }

            });

            // Used to debug SMTP issues
            session.setDebug(true);

            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(msg);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            return "Sent message successfully.";
        } catch (MessagingException mex) {
            logger.error("MessagingException");
            mex.printStackTrace();
            return mex.getMessage();
        } catch (FileNotFoundException e) {
            logger.error("FileNotFound");
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error("IOException");
            throw new RuntimeException(e);
        }
    }

}