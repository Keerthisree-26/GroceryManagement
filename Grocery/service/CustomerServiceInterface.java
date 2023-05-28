package com.gms.jpa.service;

import com.gms.jpa.model.Customer;

public interface CustomerServiceInterface 
{
	public String registerCustomer(Customer customer);
	public Customer loginCustomer(Integer customerId,String password);
	public Customer findCustomerByCard(String cardNumber);
}
