package vendingmachine.dto;

import java.math.BigDecimal;

public enum Currency {

    // usual names for US coins
    PENNY(new BigDecimal("0.01")),
    NICKEL(new BigDecimal("0.05")),
    DIME(new BigDecimal("0.10")),
    QUARTER(new BigDecimal("0.25"));


    private BigDecimal value;

    //constructor
    Currency(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

}
