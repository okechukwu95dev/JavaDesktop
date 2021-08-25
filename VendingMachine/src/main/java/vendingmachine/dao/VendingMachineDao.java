package vendingmachine.dao;

import vendingmachine.dto.Change;
import vendingmachine.dto.InventoryItem;
import java.util.List;

public interface VendingMachineDao {
    //get all items
    List<InventoryItem> getAllItems();

    Change getCoins();

    void loadItems() throws VendingMachineDaoException;

    void saveItems() throws VendingMachineDaoException;

    void saveItems(List<InventoryItem> items, Change coins) throws VendingMachineDaoException;

    void clearInventory();

    //USED ONLY IN TEST(TRYING TO EXTEND PROGRAM)
    void addItem(InventoryItem item);


}
