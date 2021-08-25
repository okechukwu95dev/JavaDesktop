package vendingmachine.service;

import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoException;
import vendingmachine.dto.Change;
import vendingmachine.dto.InventoryItem;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoException;
import vendingmachine.dto.Change;
import vendingmachine.dto.InventoryItem;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class VendingMachineServiceImpl implements VendingMachineService {

    VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;
    private BigDecimal balance;
    private Change coinInventory;
    private List<InventoryItem> itemList;
    private Change returnedChange;

    //SERVICE LAYER CONSTRUCTOR
    public VendingMachineServiceImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) throws VendingMachineDaoException {
        this.dao = dao;
        this.auditDao = auditDao;
        //SET BALANCE
        balance = new BigDecimal("0.00");
        try {
            dao.loadItems();
        } catch (VendingMachineDaoException e) {
            throw e;
        }
        itemList = dao.getAllItems();
//        itemList.sort(Comparator.comparing(InventoryItem::getName));
        coinInventory = dao.getCoins();
    }

    //RETURNS BALANCE FROM MACHINE
    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    //LOOPS THROUGH ITEM LIST AND RETURNS ITEM
    @Override
    public InventoryItem getItem(String name) throws ItemNotFoundException {
        for (InventoryItem item : itemList) {
            if (name.equals(item.getName())) {
                return item;
            }
        }

        throw new ItemNotFoundException("Item does not exist.");
    }

    //RETURN THE ALL THE ITEMS IN THE ITM LIST ITEMS FROM THE DAO METHOD
    @Override
    public List<InventoryItem> getAllItems() {
        return itemList;
    }

    //ADD FUNDS TO VENDING MACHINE (COINS)
    @Override
    public BigDecimal addMoney(Change coins) throws VendingMachineDaoException {
        if (coins!=null){
        balance = balance.add(coins.getBalance());
        coinInventory.adjustBy(coins);
        this.auditDao.writeAuditEntry("AMOUNT: " + getBalance().toString() + " ADDED");
        }
        return balance;
    }

    //ADD FUNDS TO VENDING MACHINE (COINS)
    @Override
    public BigDecimal addMoney(BigDecimal money) throws VendingMachineDaoException {
        return addMoney(new Change(money));
    }

    //VEND ITEM
    @Override
    public void vendItem(String name) throws ItemNotFoundException, InsufficientFundsException, ZeroInventoryException, VendingMachineDaoException {
        InventoryItem item = getItem(name);
        if (item.getStockLevel() <= 0) {//IF NO STOCK
            throw new ZeroInventoryException("Item out of stock.");
        }

        if (balance.compareTo(item.getPrice()) < 0) {//IF BALANCE IS NOT ENOUGH
            throw new InsufficientFundsException("Insufficient funds, please add more and try again.");
        }


        //ADJUST BALANCE
        balance = balance.subtract(item.getPrice());
        item.setStockLevel(item.getStockLevel() - 1);

        //UPDATE ITEM IN ITEM LIST
        int i = itemList.indexOf(item);
        itemList.remove(i);
        itemList.add(i, item);
        //WRITE TO ROSTER
        this.auditDao.writeAuditEntry("ITEM:  " + item.getName() + " VENDED");

    }

    //GIVE USER CHANGE
    @Override
    public Change coinReturn() throws  VendingMachineDaoException {
        returnedChange = coinInventory.subtractRespectingPositiveCoinTotals(new Change(balance));
        balance = new BigDecimal("0.00");
        this.auditDao.writeAuditEntry("$" + returnedChange.getBalance().toString() + " RETURNED");
        return returnedChange;
    }

    //SAVE ON QUIT and WRITE TO FILE
    @Override
    public void quit() throws VendingMachineDaoException {
        dao.saveItems(itemList, coinInventory);
    }

    @Override
    public void clearInventory() {
        itemList.clear();
    }

    @Override
    public void addItem(InventoryItem item) {
        itemList.add(item);
    }

    //SET COINS
    @Override
    public void setCoins(Change coins) {
        coinInventory = coins;
    }

}
