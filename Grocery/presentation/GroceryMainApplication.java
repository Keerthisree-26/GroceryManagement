
 package com.gms.jpa.presentation;

import java.util.Scanner;

public class GroceryMainApplication 
{
       public static void main(String[] args) 
       {
		        ProductUserInterface productUser = new ProductUserInterfaceImpl();
		        BillUserInterface billUser = new BillUserInterfaceImpl();
		        CustomerUserInterface customerUser = new CustomerUserInterfaceImpl();
		        
		        Scanner scanner = new Scanner(System.in);
		        int choice, option = 0;

	            do 
	            {
		            System.out.println("------------------------*  Grocery Management System  *---------------------------------");
		            System.out.println("........................................................................................................");
		            System.out.println("Login as:");
		            System.out.println("1: Admin");
		            System.out.println("2: Customer");
		            System.out.println("3: Exit");
		            System.out.println("........................................................................................................");
		
		            System.out.print("Enter your choice: ");
		            choice = scanner.nextInt();

		            switch (choice) 
		            {
		              case 1:
		                    String adminId, password;
		                    boolean loggedIn = false;
	
		                    do 
		                    {
		                        System.out.print("Enter Admin ID: ");
		                        adminId = scanner.next();
	                        
		                       
		                        if (adminId.equalsIgnoreCase("admin") ) 
		                        {
		                        	 System.out.print("Enter password: ");
				                        password = scanner.next();
				                        if( password.equalsIgnoreCase("password") )
				                        	{
			                            System.out.println("Login successful!");
			                            loggedIn = true;
	
			                            do 
			                            {
			                                System.out.println("-----------------------------------------------------------------------------");
			                                System.out.println("1: Add Product");
			                                System.out.println("2: Update Product stock");
			                                System.out.println("3: Delete Product");
			                                System.out.println("4: Find product by productId");
			                                System.out.println("5: Display all products");
			                                System.out.println("6: Logout");
			                                System.out.println("-----------------------------------------------------------------------------");
			                                System.out.print("Enter your option: ");
			                                option = scanner.nextInt();
		
		                                    switch (option) 
		                                    {
				                                    case 1:
			                                        productUser.inputAddProduct();
			                                        break;
				                                    case 2:
				                                        productUser.inputUpdateProduct();
				                                        break;
				                                    case 3:
				                                        productUser.inputDeleteProduct();
				                                        break;
				                                    case 4:
				                                        productUser.findProduct();
				                                        break;
				                                    case 5:
				                                        productUser.inputDisplayAllProducts();
				                                        break;
				                                    case 6:
				                                        System.out.println("Admin logout...");
				                                        break;
				                                    default:
			                                    	    System.out.println("Invalid option, try again...");
			                                  }
	                                     } //second 2 end
		                                 while (option != 6);
	                             } 
		                         else 
		                         {
	                            	System.out.println("Invalid password ");
	                             }
				                        
				                
	                         } 
		                        else {
				                       
			                        System.out.println("Invalid admin Id");
                             }
		                    }
		                    while (!loggedIn);
	                        break;
			          case 2:
					          do 
					          {
					              System.out.println("-----------------------------------------------------------------------------");
					              System.out.println("1: Register");
					              System.out.println("2: Login");
					              System.out.println("3: Exit");
					              System.out.println("-----------------------------------------------------------------------------");
					              System.out.print("Enter your option: ");
					              option = scanner.nextInt();
					              
					              switch (option) 
					              {
					              case 1:
					                  customerUser.register();
					                  break;
					              case 2:
					            	  customerUser.login();
				                do 
				                {
					                    System.out.println("-----------------------------------------------------------------------------");
					                    System.out.println("1: Add product To Cart");
					                    System.out.println("2: Display cart");
					                    System.out.println("3: Find Bill Details by Bill ID");
				                    System.out.println("4: Logout");
					                    System.out.println("-----------------------------------------------------------------------------");
					                    System.out.print("Enter your option: ");
					                    option = scanner.nextInt();
					
					                    switch (option) 
				                    {
					                        case 1:
					                            System.out.println("*********** // Product List // *********");
					                            productUser.inputDisplayAllProducts();
					                            billUser.AddProductToCart();
					                            productUser.inputDisplayAllProducts();
				                            break;
					                        case 2:
				                            billUser.displayCart();
					                            break;
					                         case 3:
				                             billUser.findBillById();
				                             break;
					                        case 4:
					                             System.out.println("Customer logout...");
				                             break;
					                        default:
					                            System.out.println("Invalid option, try again...");
					                     }
					                } 
					                while (option != 4);
					                break;
					              case 3:
					                  System.out.println("Exiting...");
					                  System.out.println("Thank you for visiting!");
					                  break;
					              default:
					                  System.out.println("Invalid option, try again...");
					          }
					      } while (option != 3);
			          
				                  
		            }           
} while (option != 3);
       }
       }
