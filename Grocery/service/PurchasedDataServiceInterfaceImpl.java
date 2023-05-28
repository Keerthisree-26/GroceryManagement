package com.gms.jpa.service;

import com.gms.jpa.dao.CustomerDaoInterface;
import com.gms.jpa.dao.CustomerDaoInterfaceImpl;
import com.gms.jpa.dao.PurchasedDataDaoInterface;
import com.gms.jpa.dao.PurchasedDataDaoInterfaceImpl;
import com.gms.jpa.model.Bill;
import com.gms.jpa.model.Product;
import com.gms.jpa.model.PurchasedData;

public class PurchasedDataServiceInterfaceImpl implements PurchasedDataServiceInterface 
{
PurchasedDataDaoInterface purchaseDao= new PurchasedDataDaoInterfaceImpl();
	@Override
	public PurchasedData save(PurchasedData purchasedData) {
		return purchaseDao.save(purchasedData);
		
	}
 
	


}
