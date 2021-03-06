package application.entities;


import com.google.gson.Gson;

import javax.persistence.*;

@Table(name = "category")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //private String description; // praegu ei ole vaja seda kasutada

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toJson(){
        return new Gson().toJson(this);
    }
/*
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;

    }
*/
}

