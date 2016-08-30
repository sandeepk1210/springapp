package springapp.web;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springapp.service.PriceModify;
import springapp.service.ProductManager;

@Controller
public class InventoryController {
	private Logger logger = Logger.getLogger(getClass());
	public static String homePage = "home";
	public static String priceIncreasePage = "priceincrease";

	@Autowired
	private ProductManager productManager;

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	@RequestMapping({"/", "/home"})
	public String showHomePage(Map<String, Object> map){
		String now = (new Date()).toString();

		map.put("now", now);
		logger.info("Returning hello view with " + now);

		map.put("products", this.productManager.getProducts());

		return homePage;
	}

	@RequestMapping(value="/priceincrease", method=RequestMethod.GET)
	public String showIncreaseAllPrices(Map<String, Object> map){
		map.put("priceModify", new PriceModify());

		logger.info("Returning price increase home page, where you could increase product prices.");
		return priceIncreasePage;
	}

	@RequestMapping(value="/priceincrease", method=RequestMethod.POST)
	public String priceIncreaseFromForm(@Valid PriceModify priceModify, BindingResult bindingResult){
		int percentage = priceModify.getPercentage();
		
		logger.info("Validating price increase request");
		if(bindingResult.hasErrors()){
			logger.info("Error in input provided for price validation");
			return priceIncreasePage;
		}
		productManager.modifyPrice(percentage);
		logger.info("Product prices increased by " + percentage + "%");
		return "redirect:/" + homePage;
	}
}
