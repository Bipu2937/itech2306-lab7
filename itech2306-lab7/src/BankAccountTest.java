import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(100.0, "John Doe");
    }

    @Test
    public void testInitialValues() {
        assertEquals(100.0, account.getBalance(), 0.001);
        assertEquals("John Doe", account.getOwner());
    }

    @Test
    public void testDepositPositive() {
        assertTrue(account.deposit(50));
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositNegative() {
        assertFalse(account.deposit(-10));
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawValid() {
        assertTrue(account.withdraw(40));
        assertEquals(60.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawTooMuch() {
        assertFalse(account.withdraw(200));
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawNegative() {
        assertFalse(account.withdraw(-10));
        assertEquals(100.0, account.getBalance(), 0.001);
    }
    
    @Test
    public void testTransferFromAnotherBankAccount() {
        BankAccount source = new BankAccount(200, "Source");
        BankAccount target = new BankAccount(100, "Target");

        boolean result = target.transfer(source, 50);
        assertTrue(result);
        assertEquals(150, target.getBalance(), 0.001);
        assertEquals(150, source.getBalance(), 0.001);
    }

    @Test
    public void testTransferTooMuch() {
        BankAccount source = new BankAccount(30, "Source");
        BankAccount target = new BankAccount(100, "Target");

        boolean result = target.transfer(source, 50);
        assertFalse(result);
        assertEquals(30, source.getBalance(), 0.001);
        assertEquals(100, target.getBalance(), 0.001);
    }

    @Test
    public void testTransferToSelfFails() {
        BankAccount account = new BankAccount(100, "Self");
        assertFalse(account.transfer(account, 20));
    }
}
