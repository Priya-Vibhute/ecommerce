package com.learn.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.Ecommerce.entity.Category;

@RepositoryRestResource(path = "category")
@CrossOrigin
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
