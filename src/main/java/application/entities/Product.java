package application.entities;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Column(name = "categoryId")
    private int categoryId;
    @NotNull
    private String tag;

    private String description;

    private String image;
    @NotNull
    private double price;
    @NotNull
    private int amount;

    public Product() {
    }

    public Product(@NotNull String name, @NotNull int categoryId, @NotNull String tag, String description, String image, @NotNull double price, @NotNull int amount) {
        this.name = name;
        this.categoryId = categoryId;
        this.tag = tag;
        this.description = description;
        this.image = image;
        this.price = price;
        this.amount = amount;
    }

    public Product(@NotNull String name, @NotNull String tag, String description, @NotNull double price, @NotNull int amount) {
        this.name = name;
        this.tag = tag;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", tag='" + tag + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
