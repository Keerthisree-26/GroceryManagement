package com.gms.jpa.dao;

import java.util.List;

import com.gms.jpa.model.Bill;
import com.gms.jpa.model.Product;

public interface BillDaoInterface 
{
	 public List<Product>getAllProducts();
	 public void addBill(Bill bill) ;
	 public void findBillById(Integer billId);
	 public void update(Product product);
}
