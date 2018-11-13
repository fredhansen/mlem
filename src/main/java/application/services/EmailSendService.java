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

    @Autowired
    private UserGoogleRepository userGoogleRepository;

    public Long randomLong() {

        return Math.abs(new Random().nextLong());
    }

    private void sendMail(String email) throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        try {
            FileReader reader = new FileReader(System.getProperty("user.dir")+
                    File.separator +"src" +
                    File.separator + "main" +
                    File.separator +"resources" +
                    File.separator + "application.properties");
            Properties properties = new Properties();
            properties.load(reader);
            String gmail = properties.getProperty("gmailUser");
            String password = properties.getProperty("gmailPassword");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(gmail, password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("sergei.student1@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        msg.setSubject("Hello from Welding Group!");
        msg.setContent("Hello !", "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);
        }catch (IOException ignored) {
        }
    }

    public void userDetails(Principal user) throws IOException, MessagingException {
        if (user != null){
            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) user;
            Authentication authentication = oAuth2Authentication.getUserAuthentication();
            Map<String, String> details = (Map<String, String>) authentication.getDetails();
            Map<String, String> map = new LinkedHashMap<>();
            map.put("email", details.get("email"));
            System.out.println(map.get("email"));
            // If user loggs for the first time we add him to DB
            List<Object> userGoogle = userGoogleRepository.getUserByEmail(map.get("email"));
            if (userGoogle.isEmpty()){
                userGoogleRepository.addUser(randomLong(), map.get("email"));
                sendMail(map.get("email"));
            }

        }
    }
}
