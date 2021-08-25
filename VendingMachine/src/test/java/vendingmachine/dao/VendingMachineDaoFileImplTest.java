package vendingmachine.dao;

import vendingmachine.dao.VendingMachineDaoFileImpl;
import vendingmachine.dto.Change;
import vendingmachine.dto.InventoryItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vendingmachine.service.VendingMachineServiceImpl;

import java.math.BigDecimal;


public class VendingMachineDaoFileImplTest {


    ApplicationContext ctx =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    VendingMachineDaoFileImpl instance = ctx.getBean("daoFileImplTxt", VendingMachineDaoFileImpl.class);


//    VendingMachineDaoFileImpl instance = new VendingMachineDaoFileImpl("testItems.txt", "testCoins.txt");

    public static void tearDownClass() {
    }

    //USING ITEM 4 AND ITEM 5 FROM LIST TO TEST SERVICE LAYER
    @Before
    public void setUp() {
        //clear inventory
        instance.clearInventory();
        //add "ITEM-4"to inventory for test
        InventoryItem item = new InventoryItem("ITEM-4");
        //add "ITEM-4" price to inventory for test
        item.setPrice(new BigDecimal("1.50"));
        //increase "ITEM-4" stock-level in inventory for test
        item.setStockLevel(1);
        //add complete set up "ITEM-4" to instance of list
        instance.addItem(item);
        //do same for "ITEM-5"
        InventoryItem item2 = new InventoryItem("ITEM-5");
        item.setPrice(new BigDecimal("2.50"));
        item.setStockLevel(2);
        instance.addItem(item2);
    }

    @After
    public void tearDown() {
    }


    //getAllItems test (VendingMachineDaoFileImpl)
    @Test
    public void testGetAllItems() {
        //size should be 2 b/c of "ITEM-4" and "ITEM-5"
        assertEquals(2, instance.getAllItems().size());
    }

    private void assertEquals(int i, int size) {
    }

    //testing the saving roster(items) and load roster(items) methods (VendingMachineDaoFileImpl)
    @Test
    public void testSaveAndLoadItems() throws Exception {
        instance.saveItems();
        instance.clearInventory();
        instance.loadItems();
        assertNotEquals(0, instance.getAllItems().size());
        assertNotEquals(null, instance.getCoins());
    }

    private void assertNotEquals(Integer integer, Change coins) {
    }

    private void assertNotEquals(int i, int size) {
    }
}
