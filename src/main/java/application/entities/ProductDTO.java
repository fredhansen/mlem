package application.entities;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class ProductDTO {

    /**
     * Siia pange upload kausta tee
     */
    private static String uploadFolder = "C:\\Github\\Veebirakendusteloomine\\mlem\\src\\main\\resources\\static\\img\\upload\\";

    @NotNull
    private String name;
    @NotNull

    private int categoryId;
    @NotNull
    private String tag;

    private String description;

    private MultipartFile fileUpload;


    private String image;
    @NotNull
    private double price;
    @NotNull
    private int amount;

    public ProductDTO() {
    }


    public ProductDTO(@NotNull String name, @NotNull String tag, String description, MultipartFile fileUpload, @NotNull double price, @NotNull int amount) {
        this.name = name;
        this.tag = tag;
        this.description = description;
        this.fileUpload = fileUpload;
        this.price = price;
        this.amount = amount;
    }



    public MultipartFile getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(MultipartFile fileUpload) {
        this.fileUpload = fileUpload;
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
                ", image='" + image + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }


}
