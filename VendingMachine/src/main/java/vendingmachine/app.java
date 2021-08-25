package vendingmachine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.dao.*;
import vendingmachine.dto.Currency;
import vendingmachine.service.VendingMachineService;
import vendingmachine.service.VendingMachineServiceImpl;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.VendingMachineView;

import java.math.BigDecimal;

public class app {

    public static void main(String[] args) throws VendingMachineDaoException {

//        BigDecimal p = Currency.NICKEL.getValue();
//        System.out.println(p);

//        UserIO myIo = new UserIOConsoleImpl();
//        VendingMachineView myView = new VendingMachineView(myIo);
//        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
//        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
//        VendingMachineService myService = new VendingMachineServiceImpl(myDao,myAuditDao);
//
//        VendingMachineController controller =
//                new VendingMachineController(myView,myService);
//        controller.run();


        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller =
                ctx.getBean("controller", VendingMachineController.class);
        controller.run();

    }
}
