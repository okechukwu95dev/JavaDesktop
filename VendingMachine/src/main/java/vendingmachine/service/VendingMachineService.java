package vendingmachine.service;

import vendingmachine.dao.VendingMachineDaoException;
import vendingmachine.dto.Change;
import vendingmachine.dto.InventoryItem;


import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineService {

    BigDecimal getBalance();

    InventoryItem getItem(String name) throws ItemNotFoundException;

    List<InventoryItem> getAllItems();

    BigDecimal addMoney(Change coins) throws VendingMachineDaoException;

    BigDecimal addMoney(BigDecimal money) throws VendingMachineDaoException;

    void setCoins(Change coins);

    void vendItem(String name) throws ItemNotFoundException, InsufficientFundsException, ZeroInventoryException, VendingMachineDaoException;

    void clearInventory();

    void quit() throws VendingMachineDaoException;

    void addItem(InventoryItem item);

    Change coinReturn() throws  VendingMachineDaoException;

}
