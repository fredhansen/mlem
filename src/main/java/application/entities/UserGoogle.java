package application.entities;

import javax.persistence.*;

@Entity
@Table(name = "usersGoogle")
public class UserGoogle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    public UserGoogle(String email) {
        this.email = email;
    }

    public UserGoogle(Long id, String email) {
        this.id = id;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
