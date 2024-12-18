package samar.org.finantial_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@NoArgsConstructor
public class PartMaterialsWrapper {

    private String name;
    private String description;
    private int quantity;
    private double priceUtd;
    private String buyDate;

    public PartMaterialsWrapper(String name, String description, int quantity, double priceUtd) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.priceUtd = priceUtd;

        //FORMATANDO E ADICIONANDO A DATA SEMPRE QUE O CONSTRUCTOR FOR INICIALIZADO
        LocalDateTime buyDate=LocalDateTime.now();
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fmd = buyDate.format(fm);
        this.buyDate = fmd;
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
}
