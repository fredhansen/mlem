package application.services;

import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private EmailSendService emailSendService;

    public User getUser(Principal principal) throws IOException, MessagingException {
        if (principal == null) {
            return null;
        }

        if (!principal.getName().contains("smartid")){
            emailSendService.userDetails(principal);
            OAuth2Authentication auth2Authentication = (OAuth2Authentication) principal;
            Map<String, Object> details = (Map<String, Object>) auth2Authentication.getUserAuthentication().getDetails();

            String uid = (String) details.get("id");
            String firstName = (String) details.get("given_name");
            String lastName = (String) details.get("family_name");
            String email = (String) details.get("email");

            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUid(uid);
            return user;
        }

        return null;
    }
}