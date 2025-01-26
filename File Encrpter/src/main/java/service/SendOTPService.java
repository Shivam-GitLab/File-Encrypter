package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendOTPService {
    public static void sendOTP(String email, String genOTP) {
        // Your Gmail address and App Password
        String from = "shivamkumarsaitm@gmail.com"; // Replace with your Gmail
        String password = "smxagftmzzqqjjao"; // Replace with your App Password

        // SMTP server details
        String host = "smtp.gmail.com";

        // Configure SMTP properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Create session with authentication
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        session.setDebug(true); // Enable debugging

        try {
            // Create a MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Set the "From", "To", and "Subject" fields
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Your OTP for File Enc App");

            // Set the email body
            message.setText("Your One-Time Password (OTP) is: " + genOTP);

            // Send the email
            System.out.println("Sending email...");
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException mex) {
            mex.printStackTrace(); // Print error details
        }
    }
}
