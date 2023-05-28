package com.gms.jpa.dao;

import java.util.List;

import com.gms.jpa.model.Bill;
import com.gms.jpa.model.Customer;
import com.gms.jpa.model.Product;
import com.gms.jpa.model.PurchasedData;

public interface CustomerDaoInterface 
{
	String registerCustomer(Customer customer);
	
	Customer loginCustomer(Integer customerId, String password);


	


}
