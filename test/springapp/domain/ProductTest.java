/**
 * 
 */
package springapp.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	Product product;
	
	@Before
	public void setUp() throws Exception {
	 product = new Product();
	}

	@Test
	public void testSetAndGetDescription(){
		assertNull(product.getDescription());
		
		String testDescription  = "aDescription";
		product.setDescription(testDescription);
		
		assertEquals(testDescription, product.getDescription());
	}
	
	@Test
	public void testSetAndGetPrice(){		
		double testPrice = 100.00;
		product.setPrice(testPrice);
		assertEquals(testPrice, product.getPrice(), 0);
	}

}
