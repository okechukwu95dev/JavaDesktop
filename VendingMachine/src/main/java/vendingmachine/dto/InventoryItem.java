package vendingmachine.dto;

import java.math.BigDecimal;


public class InventoryItem {

    private String name;
    private BigDecimal price;
    private int stockLevel;

    public InventoryItem(String name) {
        this.name = name;
        this.price = new BigDecimal("0.00");
        this.stockLevel = 0;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    //TODO: IMPLEMENT LATER. I CAN ADD ADMIN LEVEL FOR STOCK AND COIS INSTEAD OF MANUALLY CHANGING TXT FILES
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }


}
