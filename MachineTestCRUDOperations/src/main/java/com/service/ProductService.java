package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	// Method to get Product with pagination
    public List<Product> getProductwithPagination(int offset, int pageSize) 
    {
        int start = offset * pageSize + 1;  
        int end = start + pageSize - 1;
        return productRepository.findProductWithPagination(start, end);
    }
    
    //Save Details
  	public Product createProduct(Product Product)
  	{
  		return productRepository.save(Product);
  	}
  	
    // Get Product by ID
    public Product getProductById(Long id) {
    	return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));
    }

    // Delete Product by ID
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    // Update Product by ID
    public Product updateProductById(Long id, Product product) {
        Product p = getProductById(id);
        p.setProductName(product.getProductName());
        p.setProductPrice(product.getProductPrice());
        return productRepository.save(p);
    }
    
//     //display all records
//  	 public List<Product> findAllCategory()
//  	 {
//  		return productRepository.findAll();
//  	 }
    

}
