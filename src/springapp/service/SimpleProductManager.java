package springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import springapp.domain.Product;

@Service
public class SimpleProductManager implements ProductManager {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products){
		this.products = products;
	}

	/* 
	 * Modify the price as percentage of all the products. 
	 * Percentage can be +ve or -ve
	 */
	public void modifyPrice(int percentage){
		if(products != null && percentage != 0){
			for(Product product : products){
				double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
				product.setPrice(newPrice);
			}
		}
	}
}
