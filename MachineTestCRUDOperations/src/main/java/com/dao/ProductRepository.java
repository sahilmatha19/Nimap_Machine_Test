package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// Custom Query for Pagination 
    @Query("SELECT p FROM Product p WHERE p.productId BETWEEN :start AND :end")
    List<Product> findProductWithPagination(@Param("start") int start, @Param("end") int end);


}
