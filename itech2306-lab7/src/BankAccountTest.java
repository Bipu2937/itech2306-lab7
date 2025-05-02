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
}
