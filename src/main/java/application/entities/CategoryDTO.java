package application.entities;


import javax.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    private String description; // praegu ei ole vaja seda kasutada

    public CategoryDTO(@NotNull Long id, @NotNull String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CategoryDTO() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
