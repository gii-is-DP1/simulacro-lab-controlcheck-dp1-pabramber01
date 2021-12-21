package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productTypes")
public class ProductType extends BaseEntity {
    
	@Column(unique = true)
	@Size(min = 3, max = 50)
	String name;
	
}
