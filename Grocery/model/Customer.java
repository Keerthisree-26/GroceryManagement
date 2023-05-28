
package com.gms.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custIdSeq")
    
    @Column(length = 10)
	private Integer customerId;

    @Column(length = 20)
    private String customerName;
    
    @Column(length = 15)
    private String contactNumber;
      
    private String email;
    
    private String cardNumber;
    
    private Integer cardAmount;
  

	public Integer  getCardAmount() {
		return cardAmount;
	}

	public void setCardAmount(Integer cardAmount) {
		this.cardAmount = cardAmount;
	}

	private String password;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomer(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

//    public List<Bill> getBills() {
//        return bills;
//    }
//
//    public void setBills(List<Bill> bills) {
//        this.bills = bills;
//    }

	public void setEmail(String email) {
		this.email= email;
		
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber=contactNumber;
		
	}

	public void setPassword(String password) {
		this.password=password;
		
	}

	public String getEmail() {
		return email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void getCardNumber(String cardNumber) {
		this.cardNumber=cardNumber;
		
	}
	
	public void setCardNumber(String cardNumber) {
	    this.cardNumber = cardNumber;
	}
	
	
}
