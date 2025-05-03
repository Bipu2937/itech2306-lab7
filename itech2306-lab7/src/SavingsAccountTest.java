import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {
    private SavingsAccount savings;

    @Before
    public void setUp() {
        savings = new SavingsAccount(1000.0, "Alice", 0.20, 0.012); // 1.2% interest
    }

    @Test
    public void testInitialValues() {
        assertEquals(1000.0, savings.getBalance(), 0.001);
        assertEquals("Alice", savings.getOwner());
        assertEquals(0.20, savings.getWithdrawalFee(), 0.001);
        assertEquals(0.012, savings.getInterestRate(), 0.001);
    }

    @Test
    public void testSuccessfulWithdrawWithFee() {
        assertTrue(savings.withdraw(100));
        assertEquals(899.80, savings.getBalance(), 0.01);
    }

    @Test
    public void testFailedWithdrawDueToFee() {
        assertFalse(savings.withdraw(1000));
        assertEquals(1000.0, savings.getBalance(), 0.001);
    }

    @Test
    public void testApplyInterest() {
        savings.applyInterest(); // should add approx 0.0328767
        assertTrue(savings.getBalance() > 1000.0);
    }
}
