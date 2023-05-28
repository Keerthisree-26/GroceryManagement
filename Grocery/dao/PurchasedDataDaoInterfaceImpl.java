package com.gms.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.gms.jpa.model.PurchasedData;

public class PurchasedDataDaoInterfaceImpl implements PurchasedDataDaoInterface 
{
	private static EntityManager em = MyConnection.getEntitymanager();
    private static EntityTransaction et = em.getTransaction();

	
	public PurchasedData save(PurchasedData purchasedData) {
	
	        
	        et = em.getTransaction();
	        et.begin();
	        em.persist(purchasedData);
	        et.commit();
	        return purchasedData;
	   
        
	    }
	    
	}

	

