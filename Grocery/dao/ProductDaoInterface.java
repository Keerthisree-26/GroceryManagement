package com.gms.jpa.dao;

import java.util.List;

import com.gms.jpa.model.Product;

public interface ProductDaoInterface 
{
	String addProduct(Product product);
	 String updateProduct(Product product);
	 String deleteProduct(Integer productId);
	 Product findProduct(Integer productId);
	 List<Product> displayAllProducts();

}
