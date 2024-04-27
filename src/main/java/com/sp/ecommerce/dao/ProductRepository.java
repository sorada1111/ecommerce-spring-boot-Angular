package com.sp.ecommerce.dao;

import com.sp.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long>{
	Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
	Page<Product> findByNameContaining(@Param("name") String name, Pageable page);
}


// findByCategoryId  === select * from products where category_id =?
// http://localhost:8080/api/products/search/findByCategoryId?id=1


//findByNameContaining  === select * from products p where p.name LIKE CONCAT('%', :name,'%')
//http://localhost:8080/api/products/search/findByNameContaining?name=Python