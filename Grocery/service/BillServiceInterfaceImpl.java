package com.gms.jpa.service;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.gms.jpa.dao.BillDaoInterfaceImpl;
import com.gms.jpa.model.Bill;
import com.gms.jpa.model.Customer;
import com.gms.jpa.model.Product;

public class BillServiceInterfaceImpl implements BillServiceInterface {
	 BillDaoInterfaceImpl billDao = new BillDaoInterfaceImpl()
			 ;
	public void addBill(Bill bill) {
		billDao.addBill(bill);
		
	}
	public List<Product> getAllProducts() {
		return billDao.getAllProducts();
	}
	
	public Product getProductById(Integer productId) {
		return billDao.getProductById(productId);
	}
	
	
  public Bill findBillById(Integer billId) 
{
 return billDao.findBillById(billId);
}
public void updateProduct(Product product) {
 billDao.updateProduct(product);
	
}
public void updateCustomer(Customer customer) {
	billDao.updateCustomer(customer);
	
}


}
