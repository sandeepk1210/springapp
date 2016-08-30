package springapp.service;

import java.util.List;

import springapp.domain.Product;

public interface ProductManager {
	public List<Product> getProducts();

	public void modifyPrice(int percentage);
}
