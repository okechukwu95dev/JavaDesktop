package vendingmachine.ui;

import vendingmachine.dto.Change;
import vendingmachine.dto.InventoryItem;
import vendingmachine.service.ItemNotFoundException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    //DISPLAY THE VENDING MACHINE WITH ONLY THE AVAILABLE ITEMS
    public void displayMachine(List<InventoryItem> items, BigDecimal balance) {
        StringBuilder s;
        io.println("---------INVENTORY----------");
        io.println("");

        // Print lines of inventory if there's any stock left
        //FOR ITEMS IN INVENTORY LIST
        for (int i = 0; i < items.size(); i++) {
            //IF STOCK LEVEL OF PARTICULAR ITEM IS NOT ZERO
            if (items.get(i).getStockLevel() != 0) {
                //BUILD STRING
                s = new StringBuilder();
                //HAVE TO USE + 1 IN THE INDEX TO DISPLAY THE RIGHT THING
                //LIST INDEX SHOULD START FROM ZERO
                s.append(" ").append(i + 1).append("   FOR ");

                //Name
                s.append(" ");
                s.append(items.get(i).getName());
                //price
                s.append(":    $").append(items.get(i).getPrice());
                io.println(s.toString());
            }
        }
        io.println("");
        io.println(" 123 - Add Coins");
        io.println(" 321 - Add Notes");
        io.println(" 101 - Return Coins & EXIT");

        io.println("");
        io.println("");
        //PRINT BALANCE
        io.println(" Current Balance: $" + balance + "     ");
        io.println("");
        io.println("------------------------------");

    }

    //DOESN'T DISPLAY MENU BUT GETS SELECTION
    public int displayMainMenuAndGetChoice(List<InventoryItem> items, BigDecimal balance) {
        displayMachine(items, balance);
        int i;
        while (true) {
            i = io.readInt("Please enter your selection: ");
            //FROM LIST ABOVE (SELECTION USES LIST INDEX FOR SWITCH STATEMENT IN CONTROLLER)
            if ((0 <= i && i <= items.size()) || i == 123  || i == 101 || i == 321) {
                return i;
            }
            io.println("Invalid selection, please try again.");
        }
    }

    //GET AMOUNT OF EACH COIN PUT IN
    public Change getDeposit() {
        int q, d, n, p;

        q = io.readInt("Enter number of quarters: ", 0, Integer.MAX_VALUE);
        d = io.readInt("Enter number of dimes: ", 0, Integer.MAX_VALUE);
        n = io.readInt("Enter number of nickels: ", 0, Integer.MAX_VALUE);
        p = io.readInt("Enter number of pennies: ", 0, Integer.MAX_VALUE);
        return new Change(q, d, n, p);
    }

    //GET WHOLE NUMBER OF NOTES
    public BigDecimal getNotes(){
        int result = io.readInt("Enter amount of money you want: ", 0, Integer.MAX_VALUE);
        return BigDecimal.valueOf(result);
    }

    //DISPLAY PURCHASE
    public void displayPurchase(String itemName) {
        io.println("Success! ENJOY YOUR: " + itemName + " !");
        io.readString("Press enter to continue.");
    }

    //PRINT CHANGE THAT IS RETURNED
    public void displayGoodByeMessage(Change change) {
        io.println("Change returned:");
        io.println("Quarters: " + change.getQuarters());
        io.println("Dimes: " + change.getDimes());
        io.println("Nickels: " + change.getNickels());
        io.println("Pennies: " + change.getPennies());
        io.println("Thanks for visiting, see you soon!");
        waitToContinue();
    }

    public void displayError(Exception e) {
        io.println(e.getMessage());
        io.readString("ERROR, Press enter to continue.");
    }

    public void displayExitMessage (){
        io.println("Thanks for coming: BYE!");
    }

    public void waitToContinue() {
        io.readString("Press enter to continue.");
    }



}
