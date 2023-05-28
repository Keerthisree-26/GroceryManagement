package com.gms.jpa.service;

import java.util.List;

import com.gms.jpa.model.Bill;
import com.gms.jpa.model.Product;

public interface BillServiceInterface
{
	public List<Product>getAllProducts();
	 
	 public void addBill(Bill bill);

	public Bill findBillById(Integer billId);

	
}
