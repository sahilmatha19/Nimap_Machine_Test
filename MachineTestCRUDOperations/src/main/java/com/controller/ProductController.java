package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;
import com.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
    private ProductService productService;

	// End points to get paginated categories
    @GetMapping
    public List<Product> getPaginatedCategories(@RequestParam(value = "page", defaultValue = "0") int page,
	                                            @RequestParam(value = "size", defaultValue = "10") int size )
   {
        return productService.getProductwithPagination(page, size);
    }
    
    //Store the category details
  	@PostMapping
  	public Product createCategory(@RequestBody Product Product)
  	{
  		return productService.createProduct(Product);
  	}

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) 
    {
        return productService.getProductById(id);
    }

    // Delete product details by id
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id)
    {
        productService.deleteProductById(id);
    }

    // Update product details by id
    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody Product Product) 
    
    {
        return productService.updateProductById(id, Product);
    }
    
//  // Save Product details
//  @GetMapping("/all")
//  public List<Product> displayall()
//  {
//  	return productService.findAllCategory();
//  }

}
