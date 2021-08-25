package vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Change {

    private BigDecimal balance;
    private int quarters, dimes, nickels, pennies;

    //for test
    public Change() {
        this.balance = new BigDecimal("0.00");
        updateCoins();
    }

    //CONSTRUCTOR FOR NOTES BALANCE
    public Change(BigDecimal balance) {
        this.balance = balance;
        updateCoins();
    }

    //CONSTRUCTOR FOR COINS BALANCE
    public Change(int quarters, int dimes, int nickels, int pennies) {
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
        updateBalance();
    }

    //if balance is passed as constructor then update coins
    private void updateCoins() {
//      //DIVIDE DOWN THE NOTES BALANCE AMOUNT, USING THE REMAINDER AS BALANCE FOR NEXT ROUND OF DIVISION
        //ARRAY OTh ELEMENT IS RESULT OF DIVISION , 1ST ELEMENT IS REMAINDER
        BigDecimal[] arr = balance.divideAndRemainder(Currency.QUARTER.getValue());
        quarters = arr[0].intValue();
        arr = arr[1].divideAndRemainder(Currency.DIME.getValue());
        dimes = arr[0].intValue();
        arr = arr[1].divideAndRemainder(Currency.NICKEL.getValue());
        nickels = arr[0].intValue();
        arr = arr[1].divideAndRemainder(Currency.PENNY.getValue());
        pennies = arr[0].intValue();
    }

    //if coins is passed as constructor then update balance by multiplying each coin by value
    //and then adding together the value
    private void updateBalance() {
        if (quarters == 0 && dimes == 0 && nickels == 0 && pennies == 0) {
            balance = new BigDecimal("0.00");
        } else {
            balance = new BigDecimal(quarters * 0.25
                    + dimes * 0.10
                    + nickels * 0.05
                    + pennies * 0.01);
            //use of enum and big balance set Scale method
            balance = balance.setScale(2, RoundingMode.HALF_UP);
        }
    }


    //FOR RETURNING THE COINS CHANGE AND UPDATING OUR BALANCE AFTER ADJUSTING THE CHANGE
    public Change subtractRespectingPositiveCoinTotals(Change changeNeeded) {
        //SPLIT CHANGE NEEDED OBJECT INTO INDIVIDUAL COIN TYPES
        int quartersNeeded = changeNeeded.getQuarters();
        int dimesNeeded = changeNeeded.getDimes();
        int nickelsNeeded = changeNeeded.getNickels();
        int penniesNeeded = changeNeeded.getPennies();
        int q, d, n, p;

        //if we have more quarters or equal to whats needed
        if (this.quarters >= quartersNeeded) {
            //decrement quarters balance by quarters needed
            this.quarters -= quartersNeeded;
            //set q value to needed amount
            q = quartersNeeded;
        } else {//IF NOT
            //set q value to quarters value
            q = this.quarters;
            //decrement quarters needed by our quarters balance
            // we are basically paying here so we subtract
            quartersNeeded -= this.quarters;
            //set our quarters to a nil balance
            this.quarters = 0;
            //move remainder of quarters to smaller denominations
            //dimes and nickels can handle this because a quarter is a multiple of both elements
            dimesNeeded += (quartersNeeded * Currency.QUARTER.getValue().intValue())
                    / Currency.DIME.getValue().intValue();// TODO: CONVERT TO BIG DECIMAL INSTEAD
            nickelsNeeded += (quartersNeeded * Currency.QUARTER.getValue().intValue())
                    % Currency.DIME.getValue().intValue();
        }

        //filter changeNeeded through dimes just like in quarter
        if (this.dimes >= dimesNeeded) {
            this.dimes -= dimesNeeded;
            d = dimesNeeded;
        } else {
            d = this.dimes;
            dimesNeeded -= this.dimes;
            this.dimes = 0;
            nickelsNeeded += dimesNeeded * 2;
        }

        //filter changeNeeded through nickels just like in quarter
        if (this.nickels >= nickelsNeeded) {
            this.nickels -= nickelsNeeded;
            n = nickelsNeeded;
        } else {
            n = this.nickels;
            nickelsNeeded -= this.nickels;
            this.nickels = 0;
            penniesNeeded += nickelsNeeded * 5;
        }

        //filter changeNeeded through pennies just like in quarter
        if (this.pennies >= penniesNeeded) {
            this.pennies -= penniesNeeded;
            p = penniesNeeded;
        } else {
            p = this.pennies;
            this.pennies = 0;
        }

        //convert values of all remainder coin types after filter to full dollar balance
        updateBalance();

        // Special case for pennies
        if(penniesNeeded > 0) {
            return new Change(q,d,n, 1*penniesNeeded);
        }

        return new Change(q, d, n, p);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    //ADJUST COINS BY INPUTTED AMOUNT
    public void adjustBy(Change change) {
        Change.this.adjustBy(change.getQuarters(), change.getDimes(), change.getNickels(), change.getPennies());
    }
    public void adjustBy(int quarters, int dimes, int nickels, int pennies) {
        this.quarters += quarters;
        this.dimes += dimes;
        this.nickels += nickels;
        this.pennies += pennies;
        updateBalance();
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
        updateCoins();
    }


    public int getQuarters() {
        return quarters;
    }
    public int getNickels() {
        return nickels;
    }
    public int getDimes() {
        return dimes;
    }
    public int getPennies() {
        return pennies;
    }

    @Override
    public String toString() {
        return "Q: " + this.quarters
                + " D: " + this.dimes
                + " N: " + this.nickels
                + " P: " + this.pennies;
    }

}
