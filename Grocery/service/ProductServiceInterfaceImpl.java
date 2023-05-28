package com.gms.jpa.service;

import java.util.List;

import com.gms.jpa.dao.ProductDaoInterfaceImpl;
import com.gms.jpa.model.Product;

public class ProductServiceInterfaceImpl implements ProductServiceInterface {

ProductDaoInterfaceImpl productDao = new ProductDaoInterfaceImpl();
	
	public String addProduct(Product product) 
	{
		return productDao.addProduct(product);
	}

	public String UpdateProduct(Product product) 
	{
		return productDao.updateProduct(product);
	}
	
	public String deleteProduct(Integer productId) 
	{
		
		return productDao.deleteProduct(productId);
	}
	
	public Product findProduct(Integer productId)
	{
		return productDao.findProduct(productId);
	}
	
	public List<Product> displayAllProducts()
	{
		return productDao.displayAllProducts();
	}

	

}
