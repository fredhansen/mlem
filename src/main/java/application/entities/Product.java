package application.entities;


import com.google.gson.Gson;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;

    private Long categoryId;
    @NotNull
    private String tag;

    private String description;

    @Column(columnDefinition="MEDIUMTEXT")
    private String image;
    @NotNull
    private double price;
    @NotNull
    private int amount;

    public Product() {
    }

    public Product(@NotNull String name, @NotNull Long categoryId, @NotNull String tag, String description, String image, @NotNull double price, @NotNull int amount) {
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

    public @NotNull Long getCategoryId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(@NotNull Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toJson(){
        return new Gson().toJson(this);
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
