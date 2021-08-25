package vendingmachine.dao;

import vendingmachine.dto.Change;
import vendingmachine.dto.InventoryItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class VendingMachineDaoStubImpl implements VendingMachineDao {

    private InventoryItem onlyItem;
    private HashSet<InventoryItem> itemList = new HashSet<>();

    public VendingMachineDaoStubImpl() {
        onlyItem = new InventoryItem("Only Item");
        onlyItem.setPrice(new BigDecimal("1.00"));
        onlyItem.setStockLevel(1);

        itemList.add(onlyItem);
    }

    @Override
    public List<InventoryItem> getAllItems() {
        List<InventoryItem> list = new ArrayList<>();
        list.add(onlyItem);
        return list;
    }

    // Needed for testing
    @Override
    public void addItem(InventoryItem item) {
        // do nothing
    }
    //FOR TEST

    @Override
    public void loadItems() throws VendingMachineDaoException {
        // do nothing
    }
    @Override
    public void saveItems(List<InventoryItem> items, Change coins) throws VendingMachineDaoException {
        // Do nothing
    }
    @Override
    public void clearInventory() {
        itemList.clear();

    }
    @Override
    public void saveItems() throws VendingMachineDaoException {
        // do nothing
    }

    @Override
    public Change getCoins() {
        return new Change(10,10,10,10);
    }



}
