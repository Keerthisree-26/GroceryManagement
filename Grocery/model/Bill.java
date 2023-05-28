
package com.gms.jpa.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bill {

   

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "billIdSeq")
    @Column(length = 10)
    private Integer billId;
 
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<PurchasedData> purchasedDataList;
    
    @Column(length = 10)
	private LocalDate purchaseDate = LocalDate.now();
                                         
    private Integer quantity;
    
    

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	
	
	public List<PurchasedData> getPurchasedDataList() {
		return purchasedDataList;
	}

	public void setPurchasedDataList(List<PurchasedData> purchasedDataList) {
		this.purchasedDataList = purchasedDataList;
	}

	

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


}