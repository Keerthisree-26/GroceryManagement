package com.gms.jpa.service;

import com.gms.jpa.dao.CustomerDaoInterfaceImpl;
import com.gms.jpa.model.Customer;

public class CustomerServiceInterfaceImpl implements CustomerServiceInterface
{
	 CustomerDaoInterfaceImpl customerDao = new CustomerDaoInterfaceImpl();

	public String registerCustomer(Customer customer) {
		return customerDao.registerCustomer(customer) ;
	}

	public Customer findCustomerById(Integer customerId) {
		 return customerDao.findCustomerById(customerId);
	}

	public Customer loginCustomer(Integer customerId, String password) {
		return customerDao.loginCustomer(customerId,password);

			

	}

	public Customer getCustomerByEmail(String email) {
		return customerDao.findCustomerByEmail(email);
	}

	

	
	public Customer findCustomerByCard(String cardNumber) {
		return customerDao.findCustomerByCard(cardNumber);
	}

}
