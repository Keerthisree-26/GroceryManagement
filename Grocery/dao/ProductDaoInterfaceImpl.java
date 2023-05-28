package com.gms.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.gms.jpa.model.Product;

public class ProductDaoInterfaceImpl implements ProductDaoInterface {
	private static EntityManager em = MyConnection.getEntitymanager();
	private static EntityTransaction et = em.getTransaction();

	@Override
	public String addProduct(Product product) {
		 et = em.getTransaction();
	     et.begin();
		 em.persist(product);
		 et.commit();
		 return "Product added ";
	}

	@Override
	public String updateProduct(Product product) {
		Product pro = em.find(Product.class,product.getProductId());
		
		et = em.getTransaction();
		et.begin();
		product.setProductId(pro.getProductId());
		product.setProductName(pro.getProductName());
		product.setPrice(pro.getPrice());
		product.setStock(pro.getStock());
		
				
	    et.commit();
		return "Product updated";
	}

	@Override
	public String deleteProduct(Integer productId) {
		Product pro = em.find(Product.class, productId);
		if(pro!=null) 
		{
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(pro);
			et.commit();
			return "Product deleted";
	    }
	    else
	    {
		  return "Product  not found";
	    }
	}

	@Override
	public Product findProduct(Integer productId) {
		return em.find(Product.class, productId);
	}

	@Override
	public List<Product> displayAllProducts() {
		Query query = em.createQuery("select p from Product p");
	    List<Product> list = query.getResultList();
	    return list;
	}

}
