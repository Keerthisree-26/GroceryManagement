
package com.gms.jpa.presentation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gms.jpa.model.Bill;
import com.gms.jpa.model.Customer;
import com.gms.jpa.model.Product;
import com.gms.jpa.model.PurchasedData;
import com.gms.jpa.service.BillServiceInterface;
import com.gms.jpa.service.BillServiceInterfaceImpl;
import com.gms.jpa.service.CustomerServiceInterface;
import com.gms.jpa.service.CustomerServiceInterfaceImpl;
import com.gms.jpa.service.PurchasedDataServiceInterface;
import com.gms.jpa.service.PurchasedDataServiceInterfaceImpl;
import com.gms.jpa.validation.GroceryValidation;

public class BillUserInterfaceImpl implements BillUserInterface {

  PurchasedDataServiceInterface pdService = new PurchasedDataServiceInterfaceImpl();
  BillServiceInterfaceImpl billService = new BillServiceInterfaceImpl();
  CustomerServiceInterface customerService= new CustomerServiceInterfaceImpl();

  Scanner scanner = new Scanner(System.in);

  Integer quantity, productId, billId;
  String productName;
  //			Product product;

  Map < Integer, Integer > cart;
private boolean isValidCard;
  


  public void AddProductToCart() {
    List < Product > availableProducts = billService.getAllProducts();
    Bill bill = new Bill();
    billService.addBill(bill);
    billId = bill.getBillId();
    cart = new HashMap < > ();

    while (true) {
      System.out.print("\nEnter product name: ");
      String productName = scanner.next();
      Product selectedProduct = null;

      for (Product product: availableProducts) {
        if (product.getProductName().equalsIgnoreCase(productName)) {
          selectedProduct = product;
          break;
        }
      }

      if (selectedProduct == null) {
        System.out.println("Product not found. Please enter a valid product name.");
      } else {
        if (cart.containsKey(selectedProduct.getProductId())) {
          System.out.print("This product is already in your cart. Do you want to add more? (yes/no) : ");
          String answer = scanner.next();

          if (answer.equalsIgnoreCase("yes")) {
            System.out.println(selectedProduct + " " + selectedProduct.getStock());
            if (selectedProduct.getStock() > 0) {
              System.out.print("Enter Quantity : ");
              int quantity = scanner.nextInt();

              if (selectedProduct.getStock() >= quantity) {
                cart.put(selectedProduct.getProductId(),
                  cart.get(selectedProduct.getProductId()) + quantity);
                selectedProduct.setBill(bill);
                selectedProduct.getBill().setQuantity(quantity);
                System.out.println("Product added to cart.");
              } else {
                System.out.println("Out of stock. Available stock is: " + selectedProduct.getStock());
              }
            } else {
              System.out.println("Out of stock. Available stock is: " + selectedProduct.getStock());
            }
          }
        } else {
          System.out.print("Do you want to add this product to cart? (yes/no) : ");
          String answer = scanner.next();

          if (answer.equalsIgnoreCase("yes")) {
            if (selectedProduct.getStock() > 0) {
              System.out.print("Enter Quantity : ");
              int quantity = scanner.nextInt();

              if (selectedProduct.getStock() >= quantity) {
                cart.put(selectedProduct.getProductId(), quantity);
                selectedProduct.setBill(bill);
                selectedProduct.getBill().setQuantity(quantity);
                System.out.println("Product added to cart.");
              } else {
                System.out.println("Out of stock. Available stock is: " + selectedProduct.getStock());
              }
            } else {
              System.out.println("Out of stock. Available stock is: " + selectedProduct.getStock());
            }
          }
        }

        System.out.print("Do you want to continue adding products to the cart? (yes/no) : ");
        String continueAnswer = scanner.next();
        if (!continueAnswer.equalsIgnoreCase("yes")) {
          break;
        }
      }
    }

  }

  public void displayCart() {
    if (cart == null || cart.isEmpty()) {
      System.out.println("Cart is empty");
    } else {
      double total = 0;
      Bill bill = new Bill();

      System.out.println("\nCart contents: ");
      System.out.println("_________________________________________________________________");
      System.out.println("product ID\tProduct Name\tPrice\tQuantity\tSubtotal");
      System.out.println("_________________________________________________________________");

      List < Integer > purchasedProductIds = new ArrayList < > ();
      for (Map.Entry < Integer, Integer > entry: cart.entrySet()) {
        productId = entry.getKey();
        quantity = entry.getValue();
        Product product = billService.getProductById(productId);
        if (!purchasedProductIds.contains(productId)) {
          purchasedProductIds.add(productId);
          System.out.println(productId + "\t\t" + product.getProductName() + "\t\t" + product.getPrice() +
            "\t" + quantity + "\t\t" + (quantity * product.getPrice()));
        } else {
          for (Map.Entry < Integer, Integer > entry1: cart.entrySet()) {
            if (entry1.getKey().equals(productId)) {
              quantity += entry1.getValue();
            }
          }
          System.out.println(productId + "\t\t" + product.getProductName() + "\t\t" + product.getPrice() +
            "\t" + quantity + "\t\t" + (quantity * product.getPrice()));
        }
        total += (quantity * product.getPrice());
      }
      System.out.println("_________________________________________________________________");
      System.out.println("\t\t\t\t\t\t\tTotal:\t" + total);
      System.out.print("Would you like to purchase these products? (yes/no) : ");
      String purchaseDecision = scanner.next();

      if (purchaseDecision.equalsIgnoreCase("yes")) 
      {

        boolean paymentSuccess = false;
        while (!paymentSuccess) {
          System.out.println("Please select a payment method: ");
          System.out.println("1. Cash");
          System.out.println("2.Card");
          System.out.print("Enter your option : ");
         
          //cash
          int paymentMethod = scanner.nextInt();

          bill = null;
          if (paymentMethod == 1) {
            double paymentAmount;
            do {
              System.out.print("Please enter the payment amount: ");
              paymentAmount = scanner.nextDouble();
              if (paymentAmount < total) {
                System.out.println("Payment amount is insufficient. The total amount is " + total);
              }
            }
            while (paymentAmount < total);
            
            
            

            for (Map.Entry < Integer, Integer > entry: cart.entrySet()) {
              Integer productId = entry.getKey();
              Integer quantity = entry.getValue();
              Product product = billService.getProductById(productId);
              product.setStock(product.getStock() - quantity);
              bill = product.getBill();
              if (bill == null) {
                bill = new Bill();
                product.setBill(bill);
              }
              bill.setQuantity(quantity);

              PurchasedData purchasedData = new PurchasedData();
              purchasedData.setProduct(product);
              purchasedData.setBill(bill);
              purchasedData.setQuantity(quantity);

              pdService.save(purchasedData);

              System.out.println("\nPayment successful!!!!");
              bill = new Bill();

              LocalDate purchaseDate = bill.getPurchaseDate();
              System.out.println("\nBill ID     : " + billId);
              System.out.println("purchase Date : " + purchaseDate);

              System.out.println("\nProduct Details: ");
              System.out.println("_________________________________________________________________");
              System.out.println("product ID\tProduct Name\tPrice\tQuantity\tSubtotal");
              System.out.println("________________________________________________________________");
              for (Map.Entry < Integer, Integer > entry1: cart.entrySet()) {
                productId = entry.getKey();
                quantity = entry.getValue();
                product = billService.getProductById(productId);
                bill = product.getBill();
                bill.setBillId(billId);
                System.out.println(productId + "\t\t" + product.getProductName() + "\t\t" + product.getPrice() +
                  "\t" + quantity + "\t\t" + (quantity * product.getPrice()));
              }

              System.out.println("_________________________________________________________________");
              System.out.println("\t\t\t\t\t\tTotal:\t" + total);
              System.out.println("\t\t\t\t\t\tPaid:\t" + paymentAmount);
              System.out.println("\t\t\t\t\t\tYour Change is :" + (paymentAmount - total));
              System.out.println("Thank you for shopping with us!");
              //cart.clear();
              paymentSuccess = true;
            }

          }
          /////////////
          else if (paymentMethod == 2) 
		  {
				Integer paymentAmount=0;
		       do 
			  {
			    	System.out.print("Enter card number: ");
			        String cardNumber = scanner.next();						 
                     isValidCard = GroceryValidation.validateCardNumber(cardNumber);
				        if (!isValidCard) {
				            System.out.println("Invalid cardNumber .enter a valid card Number");
				        }
				        else 
				        {
				        Customer customer = customerService.findCustomerByCard(cardNumber); 
			            if (customer != null) {
				            	
				                System.out.print("Enter payment amount: ");
				                paymentAmount = scanner.nextInt();
				                // Deduct payment amount from the customer's balance
					                billService.updateCustomer(customer);
				                break;
				            } else {
				                System.out.println("Card not found.");
				            }
				        }    
				    } while (paymentAmount < total);
		  
		       for (Map.Entry < Integer, Integer > entry: cart.entrySet()) {
		              Integer productId = entry.getKey();
		              Integer quantity = entry.getValue();
		              Product product = billService.getProductById(productId);
		              product.setStock(product.getStock() - quantity);
		              bill = product.getBill();
		              if (bill == null) {
		                bill = new Bill();
		                product.setBill(bill);
		              }
		              bill.setQuantity(quantity);

		              PurchasedData purchasedData = new PurchasedData();
		              purchasedData.setProduct(product);
		              purchasedData.setBill(bill);
		              purchasedData.setQuantity(quantity);

		              pdService.save(purchasedData);

		              System.out.println("\nPayment successful!!!!");
		              bill = new Bill();

		              LocalDate purchaseDate = bill.getPurchaseDate();
		              System.out.println("\nBill ID     : " + billId);
		              System.out.println("purchase Date : " + purchaseDate);

		              System.out.println("\nProduct Details: ");
		              System.out.println("_________________________________________________________________");
		              System.out.println("product ID\tProduct Name\tPrice\tQuantity\tSubtotal");
		              System.out.println("________________________________________________________________");
		              for (Map.Entry < Integer, Integer > entry1: cart.entrySet()) {
		                productId = entry.getKey();
		                quantity = entry.getValue();
		                product = billService.getProductById(productId);
		                bill = product.getBill();
		                bill.setBillId(billId);
		                System.out.println(productId + "\t\t" + product.getProductName() + "\t\t" + product.getPrice() +
		                  "\t" + quantity + "\t\t" + (quantity * product.getPrice()));
		              }

		              System.out.println("_________________________________________________________________");
		              System.out.println("\t\t\t\t\t\tTotal:\t" + total);
		              System.out.println("\t\t\t\t\t\tPaid:\t" + paymentAmount);
		              System.out.println("\t\t\t\t\t\tYour Change is :" + (paymentAmount - total));
		              System.out.println("Thank you for shopping with us!");
		              //cart.clear();
		              paymentSuccess = true;
		       }
		  }  
				else 
				    {
				        System.out.println("Invalid input. Please enter 1 for Cash or 2 for Card.");
				    } 
				}
			} else {
				System.out.println("Thanks for visiting our store!");
			}
			// Empty the cart after successful payment.
			 cart.clear();
					
          }			
}
  @Override
  public void findBillById() {
    System.out.print("\nEnter Bill ID: ");
    billId = scanner.nextInt();
    BillServiceInterface billService = new BillServiceInterfaceImpl();

    Bill bill = billService.findBillById(billId);
    if (bill == null) {
      System.out.println("Bill not found.");
    } else {
      System.out.println("\nBill ID      : " + bill.getBillId());
      System.out.println("Purchase Date: " + bill.getPurchaseDate());
      System.out.println("\nProducts:");
      System.out.println("_________________________________________________________________");
      System.out.println("Product ID\tQuantity\tSubtotal");

      System.out.println("_________________________________________________________________");

      List < PurchasedData > purchasedDataList = bill.getPurchasedDataList();
      if (purchasedDataList != null) {
        double total = 0;
        for (PurchasedData purchasedData: purchasedDataList) {
          Integer price = purchasedData.getProduct() != null ? purchasedData.getProduct().getPrice() : null;
          Integer subtotal = price != null ? price * purchasedData.getQuantity() : 0;

          if (purchasedData.getProduct() != null) {
            System.out.println(purchasedData.getProduct().getProductId() + "\t\t" + "\t" + purchasedData.getQuantity() + "\t\t" + subtotal);
          }
          total += subtotal;
        }

        System.out.println("_________________________________________________________________");
        System.out.printf("\t\t\t\t\t\t\tTotal:\t%.2f\n", total);
      } else {
        System.out.println("No products found for this bill.");
      }
    }
  }

}