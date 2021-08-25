package vendingmachine.controller;

import vendingmachine.dao.VendingMachineDaoException;
import vendingmachine.dto.Change;
import vendingmachine.service.*;
import vendingmachine.ui.VendingMachineView;

public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineService service;
    private final int EXIT = 101;
    private final int ADD_COINS = 123;
    private final int ADD_NOTES = 321;

    //USE CONSTRUCTOR FOR DEPENDENCY INJECTION
    public VendingMachineController(VendingMachineView view, VendingMachineService service) {
        this.view = view;
        this.service = service;
    }

    public void run() throws VendingMachineDaoException {
        int choice;
        boolean keepGoing = true;

        while (keepGoing) {
            //DISPLAY MENU AND GET SELECTION
            choice = view.displayMainMenuAndGetChoice(service.getAllItems(), service.getBalance());

            switch (choice) {
                case (ADD_COINS):
                    service.addMoney(view.getDeposit());
                    break;
                case (ADD_NOTES):
                    service.addMoney(view.getNotes());
                    break;
                case (EXIT):
                    coinReturn();
                    keepGoing = false;
                    break;
                // If we aren't adding/returning money, we're vending an item
                // Choice-1 because the item list is 0-indexed
                default:
                    vendItem(choice);
                    break;
            }
        }
    }

    public void vendItem(int choice) {
        try {
            //HAVE TO USE -1 TO ADJUST
            String itemName = service.getAllItems().get(choice-1).getName();
            service.vendItem(itemName);
            view.displayPurchase(itemName);
        } catch (ItemNotFoundException | ZeroInventoryException | InsufficientFundsException | VendingMachineDaoException e) {
            view.displayError(e);
        }
    }

    public void coinReturn (){
        try {
            Change returnedChange = service.coinReturn();
            view.displayGoodByeMessage(returnedChange);

            service.quit();

        } catch (VendingMachineDaoException e) {
            view.displayError(e);
        }

    }


}
