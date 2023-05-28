package com.gms.jpa.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.gms.jpa.model.Product;
import com.gms.jpa.service.ProductServiceInterfaceImpl;
import com.gms.jpa.validation.GroceryValidation;

public class ProductUserInterfaceImpl implements ProductUserInterface {
	 ProductServiceInterfaceImpl productService = new ProductServiceInterfaceImpl();
	   Integer productId, price,stock;
	   String productName;
	   Scanner scanner = new Scanner(System.in);
	@Override
	public void inputAddProduct() {
	    boolean isValidProductName,isValidPrice,isValidStock;
	    isValidProductName = isValidPrice = isValidStock =false;
	   
	    do {
	        System.out.print("Enter product name : ");
	        productName = scanner.next();
	        isValidProductName = GroceryValidation.validateName(productName);
	        if (!isValidProductName) {
	            System.out.println("Invalid product name. Please enter a name containing only letters.");
	        }
	    } while (!isValidProductName);

	    do {
	    	System.out.print("Enter price of product : ");
	        price = scanner.nextInt();
	        isValidPrice = GroceryValidation.validatePrice(price);
	        if (!isValidPrice) {
	            System.out.println("Invalid price. Please enter a price greater than 0.");
	        }
	    } while (!isValidPrice);

	    do {
	        System.out.print("Enter stock : ");
	        stock = scanner.nextInt();
	        isValidStock = GroceryValidation.validateStock(stock);
	        if (!isValidStock) {
	            System.out.println("Invalid stock. Please enter a stock greater than 0.");
	        }
	    } while (!isValidStock);
	    
	    
	    
    
	    Product product = new Product();
	    product.setProductName(productName);
	    product.setPrice(price);
	    product.setStock(stock);
	    System.out.println(productService.addProduct(product));
	    
	}
      
		
	

	
	public void inputUpdateProduct() {
		System.out.print("Enter product id : ");
		productId = scanner.nextInt();
	
		Product product = productService.findProduct(productId);
		if(product!=null)
		{
			 System.out.print("Enter stock : ");
			 stock = scanner.nextInt();
	         product.setStock(stock);
	         
			System.out.println(productService.UpdateProduct(product));
		}
		else
		{
			System.out.println("Product not found...");
		}
		
	}

	@Override
	public void inputDeleteProduct() {
		System.out.print("Enter product id :");
		productId = scanner.nextInt();
		Product product = productService.findProduct(productId);
		if(product!=null)
		{
			System.out.println(productService.deleteProduct(productId));
		}
		else
		{
			System.out.println("product not exist...");
		}
		
		
	}

	@Override
	public void findProduct() {
		System.out.print("Enter product id :");
		productId = scanner.nextInt();
		Product product = productService.findProduct(productId);
		if(product!=null)
		{
			System.out.println("________________________________________________________________________________");
			System.out.println("ProductId\tProductName\tPrice\tStock");
			System.out.println("________________________________________________________________________________");
			System.out.println(product.getProductId() + "\t\t" +  product.getProductName() + "\t\t" + product.getPrice() +"\t" + product.getStock()+"\t" );
		}
		else
		{
			System.out.println("Product not found...");
		}
		
	}

	@Override
	public void inputDisplayAllProducts() {
		List<Product> list = productService.displayAllProducts();
		Iterator<Product> itr=list.iterator();
		System.out.println("____________________________________________________________________________________");
		System.out.println("ProductId\tProductName\tPrice\tStock");
		System.out.println("____________________________________________________________________________________");
		while(itr.hasNext())
		{
			Product product=itr.next();
			System.out.println(product.getProductId() + "\t\t" +  product.getProductName() + "\t\t" + product.getPrice() +"\t"+product.getStock()+ "\t");
		}
		System.out.println("____________________________________________________________________________________");
	 }
		
	}

