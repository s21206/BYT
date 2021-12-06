package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	/*
	 * Testing name of currency by comparing 2 string values. 
	 * This method returns the attribute name of Currency class
	 */
	public void testGetName() {
		assertEquals("SEK", SEK.getName());
		assertEquals("DKK", DKK.getName());
		assertEquals("EUR", EUR.getName());
	}
	
	@Test
	
	/*
	 * Testing rate of currency by comparing 2 Double values.
	 * This method returns the attribute rate of Currency class 
	 */
	public void testGetRate() {
		assertEquals((Double)0.15, SEK.getRate());
		assertEquals((Double)0.20, DKK.getRate());
		assertEquals((Double)1.5, EUR.getRate());
	}
	
	/*
	 * Testing setRate. We change rates and then checks if new rate of currency is equal to what we set
	 * This method change and returns the attribute rate of Currency class 
	 */
	@Test
	public void testSetRate() {
		SEK.setRate(2.0);
		DKK.setRate(2.0);
		EUR.setRate(2.0);
		assertEquals((Double)2.0, SEK.getRate());
		assertEquals((Double)2.0, DKK.getRate());
		assertEquals((Double)2.0, EUR.getRate());
	}
	/*
	 * Testing globalValue method by comparing 2 Integer values
	 * This method converts this value to universal by multiplying by its rate
	 */
	
	@Test
	public void testGlobalValue() {
		assertEquals((Double)15.0, SEK.universalValue(100));
		assertEquals((Double)20.0, DKK.universalValue(100));
		assertEquals((Double)150.0, EUR.universalValue(100));
	}
	
	/*
	 * Testing ValueInThisCurrency method by comparing 2 Integer values
	 * This method converts this value to universal by multiplying by its rate and then divides by other rate 
	 */
	@Test
	public void testValueInThisCurrency() {
		assertEquals((Double)10.0, SEK.valueInThisCurrency(100, EUR));
		assertEquals((Double)75.0, SEK.valueInThisCurrency(100, DKK));
		assertEquals((Double)100.0, SEK.valueInThisCurrency(100, SEK));
	}

}
