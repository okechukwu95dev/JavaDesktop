package vendingmachine.dao;

public interface VendingMachineAuditDao {
    void writeAuditEntry(String entry) throws VendingMachineDaoException;
}
