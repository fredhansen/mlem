package application.model;



import javax.persistence.*;

@Table(name = "tooted")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String Nimi;

    private int kategooriaId;

    private String Tag;

    private String Kirjeldus;

    private String pilt;

    private double Hind;

    private int Kogus;

    public Long getId() {
        return id;
    }

    public String getNimi() {
        return Nimi;
    }

    public int getKategooriaId() {
        return kategooriaId;
    }

    public String getTag() {
        return Tag;
    }

    public String getKirjeldus() {
        return Kirjeldus;
    }

    public String getPilt() {
        return pilt;
    }

    public double getHind() {
        return Hind;
    }

    public int getKogus() {
        return Kogus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Nimi='" + Nimi + '\'' +
                ", KategooriaId=" + kategooriaId +
                ", Tag='" + Tag + '\'' +
                ", Kirjeldus='" + Kirjeldus + '\'' +
                ", pilt='" + pilt + '\'' +
                ", Hind=" + Hind +
                ", Kogus=" + Kogus +
                '}';
    }
}
