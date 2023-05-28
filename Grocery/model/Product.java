

package com.gms.jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "prodIdSeq")
    
    @Column(length = 10)
    private Integer productId;
    
    @Column(length = 20)
    private String productName;
    
    @Column(length = 10)
    private Integer price;
    
    @Column(length = 10)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;

   @OneToMany(mappedBy = "product")
   private List<PurchasedData> purchasedDataList =new ArrayList<>();

	public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public 	Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public List<PurchasedData> getPurchasedDataList() {
        return purchasedDataList;
    }

    public void setPurchasedDataList(List<PurchasedData> purchasedDataList) {
        this.purchasedDataList = purchasedDataList;
    }

	

}