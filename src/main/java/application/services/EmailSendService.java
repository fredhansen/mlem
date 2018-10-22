package application.services;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class EmailSendService {

    public static void sendMail(String email) throws  MessagingException, IOException{
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sergei.student1@gmail.com", "serghstudent");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("sergei.student1@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        msg.setSubject("Hello from Welding Group!");
        msg.setContent("Hello !", "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);
    }
}
