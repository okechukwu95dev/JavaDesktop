package vendingmachine.dto;

import java.math.BigDecimal;

import vendingmachine.dto.Change;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeTest {

    Change instance = new Change();

    //constructor
    public ChangeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //TODO: CAN I CREATE A GET COINS METHOD INSTEAD OF ASSERTING EACH TYPE OF COIN INDIVIDUALLY ???

    @Test
    public void testJustQuarters() {
        instance.setBalance(new BigDecimal("1.0"));
        assertEquals(4, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }

    @Test
    public void testDimes() {
        instance.setBalance(new BigDecimal("0.20"));
        assertEquals(0, instance.getQuarters());
        assertEquals(2, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }

    @Test
    public void testNickels() {
        instance.setBalance(new BigDecimal("0.05"));
        assertEquals(0, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }


    @Test
    public void testPennies() {
        instance.setBalance(new BigDecimal("0.03"));
        assertEquals(0, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(3, instance.getPennies());
    }




    @Test
    public void testCoinsConstructor() {
        instance = new Change(1,1,1,1);
        assertEquals(1, instance.getQuarters());
        assertEquals(1, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(1, instance.getPennies());
        assertEquals(new BigDecimal("0.41"), instance.getBalance());
    }

    @Test
    public void testAddCoins() {
        instance.adjustBy(1, 1, 1, 1);
        assertEquals(new BigDecimal("0.41"), instance.getBalance());
    }


}
