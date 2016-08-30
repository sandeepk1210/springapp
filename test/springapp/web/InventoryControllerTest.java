package springapp.web;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static java.util.Arrays.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import springapp.domain.Product;
import springapp.service.ProductManager;

public class InventoryControllerTest {
	InventoryController inventoryController;
	ProductManager productManager;
	HashMap<String,Object> model;

	@Before
	public void setup(){
		productManager = mock(ProductManager.class);
		inventoryController = new InventoryController();
		inventoryController.setProductManager(productManager);
		model = new HashMap<String,Object>();
	}

	@Test
	public void testShowHomePageValidProducts() {
		/* To test what is being send into inventory model, we need to 
		 * mock :: ProductManager class
		 * Stubbing of method :: Enabled stubbing of productMager.getProducts method 
		 * 		to ensure that it returns products
		 * any :: Mockito Matcher method which creates any kind of object, to pass the matcher object. 
		 */
		List<Product> products = asList(new Product(), new Product());
		when(productManager.getProducts()).thenReturn(products);

		String viewName = inventoryController.showHomePage(model);

		assertEquals(InventoryController.homePage, viewName);
		assertEquals((new Date()).toString(), model.get("now"));

		assertEquals(products, model.get("products"));
		verify(productManager, times(1)).getProducts();

	}

	@Test
	public void testShowPriceIncreasePage(){
		String viewName = inventoryController.showIncreaseAllPrices(model);
		
		/* Expecting to return the new object of PriceIncrease*/
		//assertEquals(new PriceIncrease(), model.get("priceIncrease"));
		
		assertEquals(InventoryController.priceIncreasePage, viewName);
	}
}
