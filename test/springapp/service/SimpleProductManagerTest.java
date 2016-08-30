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

	private static int POSITIVE_PRICE_INCREASE = 10;
	private static int PRICE_DECREASE_PERCENT = 10;

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
	public void testGetProducts(){
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
	public void testIncreasePriceWithNullListOfProducts() {
		try{
			productManager = new SimpleProductManager();
			productManager.increasePrice(POSITIVE_PRICE_INCREASE);}
		catch(NullPointerException e){
			fail("Product list is null");
		}
	}

	@Test
	public void testIncreasePriceWithEmptyListOfProducts(){
		try{
			productManager = new SimpleProductManager();
			productManager.setProducts(new ArrayList<Product>());
			productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		}catch(Exception ex){
			fail("Products list is empty");
		}
	}

	@Test
	public void testIncreasePriceWithPositivePercentage(){
		productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		double expectedChairPriceWithIncrease = 22.55;
		double expectedTablePriceWithIncrease = 165.55;

		List<Product> products = productManager.getProducts();
		Product product = products.get(0);
		assertEquals(expectedChairPriceWithIncrease, product.getPrice(), 0);

		product = products.get(1);
		assertEquals(expectedTablePriceWithIncrease, product.getPrice(), 0);
	}

	@Test
	public void testIncreasePriceWithZeroPercentage(){
		productManager.increasePrice(0);
		double expectedChairPriceWithIncrease = 20.55;
		double expectedTablePriceWithIncrease = 150.55;

		List<Product> products = productManager.getProducts();
		Product product = products.get(0);
		assertEquals(expectedChairPriceWithIncrease, product.getPrice(), 2);

		product = products.get(1);
		assertEquals(expectedTablePriceWithIncrease, product.getPrice(), 2);
	}

	@Test
	public void testDecreasePriceForEmptyProduct(){
		try{
			String productName = null;
			productManager.decreasePrice(productName, 0);
		}catch(NullPointerException e){
			fail("Exception - No product passed to decrease its price");
		}
	}

	@Test
	public void testDecreasePriceForValidProduct(){
		String productName = CHAIR_DESCRIPTION;
		double expectedChairPriceWithDecrease = 18.49;
		
		int status = productManager.decreasePrice(productName, PRICE_DECREASE_PERCENT);
		assertEquals(0, status);
		
		List<Product> products = productManager.getProducts();

		Product product = products.get(0);
		assertEquals(expectedChairPriceWithDecrease, product.getPrice(), 2);

		product = products.get(1);
		assertEquals(TABLE_PRICE, product.getPrice(), 2);
	}

	@Test
	public void testDecreasePriceForInvalidProduct(){
		String productName = "InvalidProductName";
		int status = productManager.decreasePrice(productName, PRICE_DECREASE_PERCENT);
		
		assertEquals(1, status);
		
		List<Product> products = productManager.getProducts();
		Product product = products.get(0);
		assertEquals(CHAIR_PRICE, product.getPrice(), 2);

		product = products.get(1);
		assertEquals(TABLE_PRICE, product.getPrice(), 2);
	}
}