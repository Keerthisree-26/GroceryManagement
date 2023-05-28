package com.gms.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.gms.jpa.model.Bill;
import com.gms.jpa.model.Customer;
import com.gms.jpa.model.Product;
import com.gms.jpa.model.PurchasedData;

public class BillDaoInterfaceImpl {
    private static EntityManager em = MyConnection.getEntitymanager();
    private static EntityTransaction et = em.getTransaction();


    public void addBill(Bill bill) 
	{
	  try 
	  {
		   et = em.getTransaction();
		   et.begin();
		   em.persist(bill);
		   et.commit();
	   } 
	  catch (Exception ex) 
	  {
	    if (et != null && et.isActive()) 
	    {
		    et.rollback();
		}
		ex.printStackTrace();
	  }
    }


    public List < Product> getAllProducts() {
        Query query = em.createQuery("SELECT p FROM Product p");
        List < Product > products = query.getResultList();
        return products;
    }


    public Product getProductById(Integer productId) {
        Product product = em.find(Product.class, productId);
        return product;
    }

    public Bill findBillById(Integer billId) {

 Query query = em.createQuery("SELECT b FROM Bill b WHERE b.billId = :billId");
        query.setParameter("billId", billId);
        return (Bill) query.getSingleResult();

    }


    public void updateProduct(Product product) 
	{    
		  et = em.getTransaction();
		  et.begin();
		  em.merge(product);
		  et.commit();
	}


	public void updateCustomer(Customer customer) {
		 et = em.getTransaction();
		  et.begin();
		  em.merge(customer);
		  et.commit();
		
	}
	
}