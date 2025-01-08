package com.learn.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.Ecommerce.entity.Product;
import com.learn.Ecommerce.projection.ProductProjection;

@RepositoryRestResource(excerptProjection = ProductProjection.class)
@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Integer> {

  List<Product>	findByProductpriceLessThan(int price);
  List<Product>	findByProductpriceLessThanEqual(int price);
  List<Product> findByProductpriceBetween(int startPrice,int endPrice);
}
