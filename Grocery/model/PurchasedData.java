package com.gms.jpa.model;

import java.time.LocalDate;

//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//@Entity
//public class PurchasedData 
//{
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long pdId;
//	
//	public Long getPdId() {
//		return pdId;
//	}
//
//	public void setPdId(Long pdId) {
//		this.pdId = pdId;
//	}
//
//	@ManyToOne
//	@JoinColumn(name="billId")
//   private List<Bill> bill;
//	
//	@ManyToOne
//	@JoinColumn(name="prodId")
//	private List<Product> product;
//	
//	private Integer quantity;
//
//	
//	public List<Bill> getBill() {
//		return bill;
//	}
//
//	public void setBill(List<Bill> bill) {
//		this.bill = bill;
//	}
//
//	public List<Product> getProduct() {
//		return product;
//	}
//
//	public void setProduct(List<Product> product) {
//		this.product = product;
//	}
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//	
//
//}


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class PurchasedData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pdId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="billId")
    private Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prodId")
    private Product product;

   
	private Integer quantity;

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	

	

	public Product getProductId() {
		return product;
	}

	public void setProduct(Product product) {
		this.product=product;
		
	}

	public Product getProduct() {
		// TODO Auto-generated method stub
		return product;
	}

	
	

	
	

	

	

	
	
    
    
}