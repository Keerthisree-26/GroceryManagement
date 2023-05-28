package com.gms.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.gms.jpa.model.Bill;
import com.gms.jpa.model.Customer;

public class CustomerDaoInterfaceImpl implements CustomerDaoInterface {
	private static EntityManager em = MyConnection.getEntitymanager();
	private static EntityTransaction et = em.getTransaction();

	public String registerCustomer(Customer customer) {
		 et = em.getTransaction();
         et.begin();
         em.persist(customer);
         et.commit();
         return "Customer registered successfully,Please Login!";
	}

	public Customer findCustomerById(Integer customerId) {
		Customer customer = em.find(Customer.class, customerId);
		return customer;
	}

	public Customer loginCustomer(Integer customerId, String password) 
	{
	    Query query = em.createQuery("SELECT c FROM Customer c WHERE c.customerId = :customerId AND c.password = :password");
	    query.setParameter("customerId", customerId);
	    query.setParameter("password", password);
	    try {
	        Customer customer = (Customer) query.getSingleResult();
	        return customer;
	    } catch (NoResultException e) {
	        return null; 
	    }
	}

	public Customer findCustomerByEmail(String email) {

	    TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email", Customer.class);
	    query.setParameter("email", email);
	    try {
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}
	    public Customer findCustomerByCard(String cardNumber) {

		    TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.cardNumber = :cardNumber", Customer.class);
		    query.setParameter("cardNumber", cardNumber);
		    try {
		        return query.getSingleResult();
		    } catch (NoResultException e) {
		        return null;
		    }
	}
	



	
	
	

}
