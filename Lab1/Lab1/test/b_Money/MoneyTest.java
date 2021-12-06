package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	/*
	 * This method returns divided by 100 attribute amount of Money class. 
	 * Dividing by 100 is used because last 2 digits denote two decimals
	 */
	@Test
	public void testGetAmount() {
		assertEquals((Double)100.0, SEK100.getAmount());
		assertEquals((Double)10.0, EUR10.getAmount());
		assertEquals((Double)200.0, SEK200.getAmount());
		assertEquals((Double)20.0, EUR20.getAmount());
		assertEquals((Double)0.0, SEK0.getAmount());
		assertEquals((Double)0.0, EUR0.getAmount());
		assertEquals((Double)(-100.0), SEKn100.getAmount());
	}
	
	/*
	 * This method returns attribute currency of class Money
	 */
	@Test
	public void testGetCurrency() {
		assertEquals("SEK", SEK100.getCurrency().getName());
		assertEquals("EUR", EUR10.getCurrency().getName());
		assertEquals("SEK", SEKn100.getCurrency().getName());
	}
	
	/*
	 * This method overrides ToString() as it is expected 
	 */
	@Test
	public void testToString() {
		assertEquals("100.0 SEK", SEK100.toString());
		assertEquals("10.0 EUR", EUR10.toString());
		assertEquals("-100.0 SEK", SEKn100.toString());
	}
	
	
	/*
	 * This method returns universal value by multiplying this amount by this currency
	 */
	@Test
	public void testGlobalValue() {
		assertEquals((Double)15.0, SEK100.universalValue());
		assertEquals((Double)15.0, EUR10.universalValue());
		assertEquals((Double)(-15.0), SEKn100.universalValue());
		assertEquals((Double)15.0, SEK100.universalValue());
	}
	
	/*
	 * This method converts both amounts in 2 universal values and then checks those values
	 */

	@Test
	public void testEqualsMoney() {
		assertTrue(SEK100.equals(EUR10));
		assertTrue(SEK0.equals(EUR0));
		assertFalse(SEK0.equals(EUR10));

	}
	
	/*
	 * This method converts both amounts in 2 universal values, adds those values and divide sum by this rate.
	 * Then method returns object of class Money with sum of values divided by this rate multiplied by 100(adding last 2 digits) 
	 */

	@Test
	public void testAdd() {
		assertEquals((Double)200.0, SEK100.add(SEK100).getAmount());
		assertEquals((Double)100.0, SEK0.add(EUR10).getAmount());
		assertEquals((Double)20.0, EUR10.add(SEK100).getAmount());
		assertEquals((Double)30.0, EUR20.add(EUR10).getAmount());
	}

	/*
	 * This method converts both amounts in 2 universal values, subtracts those values and divide sum by this rate.
	 * Then method returns object of class Money with subtraction of values divided by this rate multiplied by 100(adding last 2 digits) 
	 */
	@Test
	public void testSub() {
		assertEquals((Double)0.0, SEK100.sub(SEK100).getAmount());
		assertEquals((Double)0.0, SEK100.sub(EUR10).getAmount());
		assertEquals((Double)(-100.0), SEK0.sub(EUR10).getAmount());
	}
	
	/*
	 * This method is using getAmount() method and checks if it is 0 or no.
	 */
	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());
		assertFalse(EUR10.isZero());

	}

	/*
	 * This method is using getAmount() method to get amount and multiply it by -1 to negate and by 100 to add 2 digits.
	 */
	@Test
	public void testNegate() {
		assertEquals((Double)(-100.0), SEK100.negate().getAmount());
		assertEquals((Double)(-10.0), EUR10.negate().getAmount());
		assertEquals((Double)0.0, SEK0.negate().getAmount());
	}
	
	/*
	 * This method is converts both values to universal value and checks equality.
	 */

	@Test
	public void testCompareTo() {
		assertEquals(0, SEK100.compareTo(SEK100));
		assertEquals(0, SEK100.compareTo(EUR10));
		assertEquals(1, SEK100.compareTo(EUR0));
		assertEquals(-1, SEK0.compareTo(SEK100));
	}
}
