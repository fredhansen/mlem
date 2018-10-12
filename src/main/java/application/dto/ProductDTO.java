package application.dto;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

import javax.validation.constraints.NotNull;

public class ProductDTO {

    @NotNull
    private String name;
    @NotNull

    private int categoryId;
    @NotNull
    private String tag;

    private String description;

    private FilePart imageFile;


    private String image;
    @NotNull
    private double price;
    @NotNull
    private int amount;

    public ProductDTO() {
    }


    public ProductDTO(@NotNull String name, @NotNull String tag, String description, @NotNull double price, @NotNull int amount) {
        this.name = name;
        this.tag = tag;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public ProductDTO(@NotNull String name, @NotNull int categoryId, @NotNull String tag, String description, FilePart imageFile, String image, @NotNull double price, @NotNull int amount) {
        this.name = name;
        this.categoryId = categoryId;
        this.tag = tag;
        this.description = description;
        this.imageFile = imageFile;
        this.image = image;
        this.price = price;
        this.amount = amount;
    }



    public FilePart getImageFile() {
        return imageFile;
    }

    public void setImageFile(FilePart imageFile) {
        this.imageFile = imageFile;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(int categoryId) {
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

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", tag='" + tag + '\'' +
                ", description='" + description + '\'' +
                ", imageFile=" + imageFile +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
