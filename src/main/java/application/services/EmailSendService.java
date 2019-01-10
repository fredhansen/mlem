package application.services;


import application.repo.UserGoogleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Service
public class EmailSendService {

    private final UserGoogleRepository userGoogleRepository;

    @Autowired
    public EmailSendService(UserGoogleRepository userGoogleRepository) {
        this.userGoogleRepository = userGoogleRepository;
    }

    private Long randomLong() {

        return Math.abs(new Random().nextLong());
    }

    private String composeMessage(){
        return null;
    }

    private void sendMail(String email, String subject, String message) throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(System.getenv("G_USERNAME"), System.getenv("G_PASSWORD"));
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("sergei.student1@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        msg.setSubject(subject);
        msg.setContent(message, "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }


    public void userDetails(Principal user) throws IOException, MessagingException {
        if (user != null) {
            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) user;
            Authentication authentication = oAuth2Authentication.getUserAuthentication();
            Map<String, String> details = (Map<String, String>) authentication.getDetails();
            Map<String, String> map = new LinkedHashMap<>();
            map.put("email", details.get("email"));
            System.out.println(map.get("email"));
            // If user loggs for the first time we add him to DB
            List<Object> userGoogle = userGoogleRepository.getUserByEmail(map.get("email"));
            if (userGoogle.isEmpty()) {
                userGoogleRepository.addUser(randomLong(), map.get("email"));
                sendMail(map.get("email"), "Hello from Welding Group!", "Hello!");
            }

        }
    }
}
