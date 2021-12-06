package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
		assertEquals("Nordea", Nordea.getName());
		assertEquals("DanskeBank", DanskeBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals("SEK", SweBank.getCurrency().getName());
		assertEquals("SEK", Nordea.getCurrency().getName());
		assertEquals("DKK", DanskeBank.getCurrency().getName());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		
		try {
			SweBank.openAccount("123");
			SweBank.openAccount("Ulrika");
		} catch (AccountExistsException e) {
			System.out.println("Account exists");
		}
		
		assertEquals((Double)0.0, SweBank.getBalance("123").getAmount());

	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		try {
			SweBank.deposit("Ulrika", new Money(10000, SEK));
			SweBank.deposit("Ulrik111a", new Money(10000, SEK));
		} catch (AccountDoesNotExistException e) {
			System.out.println("Account do not exist");
		}
		assertEquals((Double)100.0, SweBank.getBalance("Ulrika").getAmount());
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		try {
			SweBank.withdraw("Ulrika", new Money(10000, SEK));
			SweBank.withdraw("Ulrik111a", new Money(10000, SEK));
		} catch (AccountDoesNotExistException e) {
			System.out.println("Account do not exist");
		}
		
		assertEquals((Double)(-100.0), SweBank.getBalance("Ulrika").getAmount());
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		try {
			assertEquals((Double)(0.0), SweBank.getBalance("Ulrika").getAmount());
			assertEquals((Double)(324.0), SweBank.getBalance("Ulrika11").getAmount());
		} catch (AccountDoesNotExistException e) {
			System.out.println("Account do not exist");
		}
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		try {
			SweBank.transfer("Ulrika", Nordea, "Gertrud", new Money(100, SEK));
			SweBank.transfer("Ulrika", "Bob", new Money(100, SEK));
			assertEquals((Double)(-2.0), SweBank.getBalance("Ulrika"));
			assertEquals((Double)1.0, DanskeBank.getBalance("Gertrud"));
			assertEquals((Double)1.0, SweBank.getBalance("Bob"));
		} catch (AccountDoesNotExistException e) {
			System.out.println("Account do not exist");
		}
		
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Ulrika", "1", 0, 0, new Money(10000, SEK), DanskeBank, "Gertrud");
		SweBank.tick();
		assertEquals((Double)75.0, DanskeBank.getBalance("Gertrud").getAmount());
		assertEquals((Double)(-100.0), SweBank.getBalance("Ulrika").getAmount());
	}
}
