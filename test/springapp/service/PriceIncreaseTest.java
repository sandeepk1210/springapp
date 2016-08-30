/**
 * 
 */
package springapp.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriceIncreaseTest {

	PriceModify priceModify;

	@Before
	public void setUp() throws Exception {
		priceModify = new PriceModify();
	}

	@Test
	public void testSetAndGetPercentage(){
		int testPercentage = 10;

		priceModify.setPercentage(testPercentage);
		assertEquals(testPercentage, priceModify.getPercentage());

	}
}
