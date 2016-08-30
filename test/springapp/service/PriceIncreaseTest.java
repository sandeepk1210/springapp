/**
 * 
 */
package springapp.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriceIncreaseTest {

	PriceIncrease priceIncrease;

	@Before
	public void setUp() throws Exception {
		priceIncrease = new PriceIncrease();
	}

	@Test
	public void testSetAndGetPercentage(){
		int testPercentage = 10;

		priceIncrease.setPercentage(testPercentage);
		assertEquals(testPercentage, priceIncrease.getPercentage());

	}
}
