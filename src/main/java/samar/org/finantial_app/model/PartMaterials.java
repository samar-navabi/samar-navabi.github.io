package samar.org.finantial_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@Entity
public class PartMaterials
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int quantity;
    private double priceUtd;
    private String buyDate;
    @ManyToOne
    private Part part;

    public PartMaterials(String name, String description, int quantity, double priceUtd, String buyDate, Part part) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.priceUtd = priceUtd;
        this.buyDate = buyDate;
        this.part = part;
    }

    public PartMaterials()
    {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceUtd() {
        return priceUtd;
    }

    public void setPriceUtd(double priceUtd) {
        this.priceUtd = priceUtd;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}
