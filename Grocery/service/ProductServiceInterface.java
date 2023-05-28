package com.gms.jpa.service;

import java.util.List;

import com.gms.jpa.model.Product;

public interface ProductServiceInterface
{
public String addProduct(Product product) ;
public String UpdateProduct(Product product);
public String deleteProduct(Integer productId) ;
public Product findProduct(Integer productId);
public List<Product> displayAllProducts();

}
