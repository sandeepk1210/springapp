package springapp.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

import springapp.domain.Product;

public class SimpleProductManagerTest {

	private SimpleProductManager productManager;
	private List<Product> products;

	private static int PRODUCT_COUNT = 2;

	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair";

	private static Double TABLE_PRICE = new Double(150.50);
	private static String TABLE_DESCRIPTION = "Table";

	private static int PRICE_INCREASE = 10;
	private static int PRICE_DECREASE = -10;

	@Before
	public void setUp() throws Exception {
		productManager = new SimpleProductManager();
		products = new ArrayList<Product>();

		Product product = new Product();
		product.setDescription("Chair");
		product.setPrice(CHAIR_PRICE);
		products.add(product);

		product = new Product();
		product.setDescription("Table");
		product.setPrice(TABLE_PRICE);
		products.add(product);

		productManager.setProducts(products);
	}

	@Test
	public void testGetProductsWithNoProducts() {
		productManager = new SimpleProductManager();
		assertNull(productManager.getProducts());
	}

	@Test
	public void testGetProductsWithValidProdcuts(){
		List<Product> products = productManager.getProducts();
		assertNotNull(products);
		assertEquals(PRODUCT_COUNT, products.size());

		Product product = products.get(0);
		assertEquals(CHAIR_DESCRIPTION, product.getDescription());
		assertEquals(CHAIR_PRICE, product.getPrice());

		product = products.get(1);
		assertEquals(TABLE_DESCRIPTION, product.getDescription());
		assertEquals(TABLE_PRICE, product.getPrice());	
	}

	@Test
	public void testModifyPriceWithNullListOfProducts() {
		try{
			productManager = new SimpleProductManager();
			productManager.modifyPrice(PRICE_INCREASE);
		}
		catch(NullPointerException e){
			fail("Product list is null");
		}
	}

	@Test
	public void testModifyPriceWithPositivePercentage(){
		productManager.modifyPrice(PRICE_INCREASE);
		double expectedChairPriceWithIncrease = 22.55;
		double expectedTablePriceWithIncrease = 165.55;

		List<Product> products = productManager.getProducts();
		Product product = products.get(0);
		assertEquals(expectedChairPriceWithIncrease, product.getPrice(), 0);

		product = products.get(1);
		assertEquals(expectedTablePriceWithIncrease, product.getPrice(), 0);
	}
	
	@Test
	public void testModifyPriceWithNegativePercentage(){
		productManager.modifyPrice(PRICE_DECREASE);
		double expectedChairPriceWithDecrease = 18.45;
		double expectedTablePriceWithDecrease = 135.45;

		List<Product> products = productManager.getProducts();
		Product product = products.get(0);
		assertEquals(expectedChairPriceWithDecrease, product.getPrice(), 0);

		product = products.get(1);
		assertEquals(expectedTablePriceWithDecrease, product.getPrice(), 0);
	}

	@Test
	public void testModifyPriceWithZeroPercentage(){
		productManager.modifyPrice(0);
		double expectedChairPriceWithIncrease = CHAIR_PRICE;
		double expectedTablePriceWithIncrease = TABLE_PRICE;

		List<Product> products = productManager.getProducts();
		Product product = products.get(0);
		assertEquals(expectedChairPriceWithIncrease, product.getPrice(), 2);

		product = products.get(1);
		assertEquals(expectedTablePriceWithIncrease, product.getPrice(), 2);
	}
}