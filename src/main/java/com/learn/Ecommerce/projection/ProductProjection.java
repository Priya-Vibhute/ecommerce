package com.learn.Ecommerce.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ProductProjection {
	
	String getProductName();
	@Value("#{target.category?.categoryName}")
	String getCategory();

}
