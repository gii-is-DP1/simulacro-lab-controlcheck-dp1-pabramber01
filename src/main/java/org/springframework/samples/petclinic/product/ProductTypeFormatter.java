package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType> {

	@Autowired
	private ProductService productService;
	
    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        ProductType productType = this.productService.getProductType(text);
        if (productType != null)
        	return productType;
        else
        	throw new ParseException("type not found:" + text, 0);
    }
    
}
