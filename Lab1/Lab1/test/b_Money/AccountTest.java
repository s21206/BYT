package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		 testAccount.addTimedPayment("1", 2, 4, new Money(100, SEK), SweBank, "Alice");
		 testAccount.addTimedPayment("2", 2, 4, new Money(100, SEK), SweBank, "Alice");
		 assertTrue(testAccount.timedPaymentExists("1"));
		 assertFalse(testAccount.timedPaymentExists("sdfsd"));
		 
		 testAccount.removeTimedPayment("2");
		 assertFalse(testAccount.timedPaymentExists("2"));
		
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("3", 2, 0, new Money(100, SEK), SweBank, "Alice");
		assertTrue(testAccount.timedPaymentExists("3"));
		assertFalse(testAccount.timedPaymentExists("33"));
	}

	@Test
	public void testAddWithdraw() {
		testAccount.withdraw(new Money(100, SEK));
		assertEquals((Double)99999.0, testAccount.getBalance().getAmount());
	}
	
	@Test
	public void testGetBalance() {
		assertEquals((Double)100000.0, testAccount.getBalance().getAmount());
	}
}
