package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    
	private final ProductService productService;
	
	private static final String VIEWS_PRODUCT_CREATE_FORM = "products/createOrUpdateProductForm";
	private static final String VIEWS_HOME = "welcome";
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping("/create")
	public String initCreationForm(ModelMap model) {
		Product product = new Product();
		List<ProductType> productTypes = this.productService.getAllTypeProducts();
		model.addAttribute("product", product);
		model.addAttribute("types", productTypes);
		return VIEWS_PRODUCT_CREATE_FORM;
	}
	
	@PostMapping("/create")
	public String processCreationForm(@Valid Product product, BindingResult result) {
		
		if (result.hasErrors()) {
			return VIEWS_PRODUCT_CREATE_FORM;
		} else {
			this.productService.save(product);
			return VIEWS_HOME;
		}
		
	}
	
}
