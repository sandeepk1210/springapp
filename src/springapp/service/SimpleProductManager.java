package springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

//import springapp.dao.ProductDao;
import springapp.domain.Product;

@Service
public class SimpleProductManager implements ProductManager {

	private List<Product> products;
	//private ProductDao productDao;

	public void increasePrice(int percentage){
		if(products != null){
			for(Product product : products){
				double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
				product.setPrice(newPrice);
			}
		}
	}

	public List<Product> getProducts() {
		//return productDao.getProductList();
		return products;
	}

	public void setProducts(List<Product> products){
		this.products = products;
	}

	@Override
	public int decreasePrice(String productName, int percentage) {
		if(productName != null){
			for(Product product : products){
				if(product.getDescription() == productName){
					double newPrice = product.getPrice().doubleValue() * (100 - percentage) / 100;
					product.setPrice(newPrice);
					return 0;
				}
			}
		}
		return 1;
	}
}
