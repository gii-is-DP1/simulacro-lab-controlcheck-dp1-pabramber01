package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
    public List<Product> findAll();
    
    @Query("SELECT productType FROM ProductType productType")
    public List<ProductType> findAllProductTypes();
    
    @Query("SELECT productType FROM ProductType productType WHERE productType.name = :name")
    public ProductType findProductTypeByName(@Param("name") String name);
    
    @Query("SELECT product FROM Product product WHERE product.price < ?1")
    public List<Product> findByPriceLessThan(@Param("price") double price);
    
    public Optional<Product> findById(int id);
    
    public Product findByName(String name);
    
    public Product save(Product p);
    
}
