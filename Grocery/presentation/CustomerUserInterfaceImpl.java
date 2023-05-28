//package com.gms.jpa.presentation;
//
//import java.util.Random;
//import java.util.Scanner;
//
//import com.gms.jpa.model.Customer;
//import com.gms.jpa.service.CustomerServiceInterfaceImpl;
//import com.gms.jpa.validation.GroceryValidation;
//
//public class CustomerUserInterfaceImpl implements CustomerUserInterface 
//{
//	CustomerServiceInterfaceImpl customerService = new CustomerServiceInterfaceImpl();
//    Integer customerId;
//   
//    int option;
//     String customerName, email , password,contactNumber;
//	Integer cardAmount;
//	String cardNumber;
//     
//    Scanner scanner = new Scanner(System.in);
//    ProductUserInterface productUser = new ProductUserInterfaceImpl();
//    BillUserInterfaceImpl billUser=new BillUserInterfaceImpl ();
//    Customer customer = new Customer();
//
//	public void register() {
//        boolean flagCustomerName, flagEmail, flagContactNumber, flagCardNumber,flagPassword,flagcardAmount;
//        flagCustomerName = flagEmail = flagContactNumber = flagCardNumber = flagPassword = flagcardAmount= true;
//
//        do {
//            System.out.print("Enter Full Name:");
//            customerName = scanner.next();
//
//            flagCustomerName = GroceryValidation.validateName(customerName);
//            if (!flagCustomerName) {
//                System.out.println("Invalid name. Please enter a name containing only letters.");
//            }
//        } while (!flagCustomerName);
//
//        do {
//            System.out.print("Enter Email Id:");
//            email = scanner.next();
//
//            flagEmail = GroceryValidation.validateEmail(email);
//            if (!flagEmail) 
//            {
//                System.out.println("Enter Email in format (Example12@gmail.com)");
//            } else {
//                Customer existingCustomer = customerService.getCustomerByEmail(email);
//                if (existingCustomer != null) {
//                    System.out.println("This email is already registered.");
//                    flagEmail = false;
//                }
//            }
//        } while (!flagEmail);
//
//        do {
//            System.out.print("Enter Contact Number:");
//            contactNumber = scanner.next();
//
//            flagContactNumber = GroceryValidation.validateMobile(contactNumber);
//            if (!flagContactNumber) {
//                System.out.println("Enter contact Number in valid Format");
//            }
//        } while (!flagContactNumber);
//        
//        
//		do {
//            System.out.print("Do you want a card? (yes/no): ");
//            String customerType = scanner.next();
//
//            if (customerType.equalsIgnoreCase("yes")) {
//                boolean validCardAmount = false;
//                Integer cardAmount = 0;
//                do {
//                    System.out.print("Enter card amount (between 2000 and 10000): ");
//                    cardAmount = scanner.nextInt();
//                    if (cardAmount >= 2000 && cardAmount <= 10000) {
//                        validCardAmount = true;
//                    } else {
//                        System.out.println("Invalid card amount. Please enter a value between 2000 and 10000.");
//                    }
//                } while (!validCardAmount);
//                
//                customer.setCardAmount(cardAmount);
//                
//                System.out.println("Generate your own card number:");
//                cardNumber = scanner.next();
//                flagCardNumber = GroceryValidation.validateCardNumber(cardNumber);
//                if(!flagCardNumber) 
//                {
//                	System.out.println("Enter a String which has 2 special characters, at least 1 uppercase letter, and at least 2 digits)");
//                }else 
//                {
//                	Customer existingCardNumber = customerService.findCustomerByCard(cardNumber);
//                	if (existingCardNumber != null) {
//                        System.out.println(" You cannot use this as your card!.please try other to add aother card number");
//                        flagCardNumber = false;
//                    }
//                }}
//               
//               
//                else {
//                System.out.println("No card generated.");
//               
//            }
//        } while (!flagCardNumber);
//
//        do {
//            System.out.print("Set your password: ");
//            password = scanner.next();
//
//            flagPassword = GroceryValidation.validatePassword(password);
//            if (!flagPassword) {
//                System.out.println("Password should have at least one uppercase, one lowercase, one digit, one special character, and a minimum length of 8 characters");
//            }
//        } while (!flagPassword);
//        
//        customer.setCustomerName(customerName);
//        customer.setEmail(email);
//        customer.setContactNumber(contactNumber);
//
//        customer.getCardNumber(cardNumber);
//        customer.setPassword(password);
//
//        System.out.println(customerService.registerCustomer(customer));
//
//        System.out.println(customerName +"   your Customer Id : "+ customer.getCustomerId());
//        System.out.println("\t"+" your card number : "+ cardNumber );
//	}
//
//
//	public void login() {
//        boolean isLoggedIn = false;
//        int attempts = 0;
//
//        do
//        {
//          System.out.print("Enter your customer Id: ");
//
//          customerId = scanner.nextInt();
//          Customer customer1 = customerService.findCustomerById(customerId);
//      if (customer1!=null)
//          {
//            System.out.print("Enter your password: ");
//            password = scanner.next();
//            if (password.equalsIgnoreCase(password)) 
//            {
//              Customer customer = customerService.loginCustomer(customerId, password);
//
//              if (customer == null) 
//              {
//                System.out.println("Invalid customer  password. Please try again.");
//                attempts++;
//              } 
//                else {
//                System.out.println("\nWelcome " + customer.getCustomerName() + "!");
//                isLoggedIn = true;
//                System.out.println("Welcome to grocery shop!");
//                productUser.inputDisplayAllProducts();
//                }
//               
//              }
//            else 
//              {
//            	  System.out.println("Invalid password");
//              }
//
//       }else 
//        {
//        	System.out.println("Invalid Customer Id! please register yourself");
//        	
//        	
//        }
////            
//            } while (!isLoggedIn && attempts < 3);
//
//            if (!isLoggedIn) {
//              System.out.println("Too many attempts. Please try again later.");
//            }
//          }
//
//}
package com.gms.jpa.presentation;

import java.util.Random;
import java.util.Scanner;

import com.gms.jpa.model.Customer;
import com.gms.jpa.service.CustomerServiceInterfaceImpl;
import com.gms.jpa.validation.GroceryValidation;

public class CustomerUserInterfaceImpl implements CustomerUserInterface 
{
	CustomerServiceInterfaceImpl customerService = new CustomerServiceInterfaceImpl();
    Integer customerId;
   
    int option;
     String customerName, email , password,contactNumber;
	Integer cardAmount;
     
    Scanner scanner = new Scanner(System.in);
    ProductUserInterface productUser = new ProductUserInterfaceImpl();
    BillUserInterfaceImpl billUser=new BillUserInterfaceImpl ();
    Customer customer = new Customer();

	public void register() {
        boolean flagCustomerName, flagEmail, flagContactNumber, flagGenerateCardNumber,flagPassword,flagcardAmount;
        flagCustomerName = flagEmail = flagContactNumber = flagGenerateCardNumber = flagPassword = flagcardAmount= true;

        do {
            System.out.print("Enter Full Name:");
            customerName = scanner.next();

            flagCustomerName = GroceryValidation.validateName(customerName);
            if (!flagCustomerName) {
                System.out.println("Invalid name. Please enter a name containing only letters.");
            }
        } while (!flagCustomerName);

        do {
            System.out.print("Enter Email Id:");
            email = scanner.next();

            flagEmail = GroceryValidation.validateEmail(email);
            if (!flagEmail) 
            {
                System.out.println("Enter Email in format (Example12@gmail.com)");
            } else {
                Customer existingCustomer = customerService.getCustomerByEmail(email);
                if (existingCustomer != null) {
                    System.out.println("This email is already registered.");
                    flagEmail = false;
                }
            }
        } while (!flagEmail);

        do {
            System.out.print("Enter Contact Number:");
            contactNumber = scanner.next();

            flagContactNumber = GroceryValidation.validateMobile(contactNumber);
            if (!flagContactNumber) {
                System.out.println("Enter contact Number in valid Format");
            }
        } while (!flagContactNumber);
        String cardNumber = "";
        do {
            System.out.print("Do you want a card? (yes/no): ");
            String customerType = scanner.next();

            if (customerType.equalsIgnoreCase("yes")) {
                boolean validCardAmount = false;
                Integer cardAmount = 0;
                do {
                    System.out.print("Enter card amount (between 2000 and 10000): ");
                    cardAmount = scanner.nextInt();
                    if (cardAmount >= 2000 && cardAmount <= 10000) {
                        validCardAmount = true;
                    } else {
                        System.out.println("Invalid card amount. Please enter a value between 2000 and 10000.");
                    }
                } while (!validCardAmount);
                
                customer.setCardAmount(cardAmount);
                cardNumber = generateCardNumber();
                System.out.println("Customer Name: " + customerName);
                System.out.println("Card Number: " + cardNumber);
                flagGenerateCardNumber = true;
            } else {
                System.out.println("No card generated.");
                flagGenerateCardNumber = true;
            }
        } while (!flagGenerateCardNumber);

        do {
            System.out.print("Set your password: ");
            password = scanner.next();

            flagPassword = GroceryValidation.validatePassword(password);
            if (!flagPassword) {
                System.out.println("Password should have at least one uppercase, one lowercase, one digit, one special character, and a minimum length of 8 characters");
            }
        } while (!flagPassword);
        
        customer.setCustomerName(customerName);
        customer.setEmail(email);
        customer.setContactNumber(contactNumber);

        customer.getCardNumber(cardNumber);
        customer.setPassword(password);

        System.out.println(customerService.registerCustomer(customer));

        System.out.println(customerName +"   your Customer Id : "+ customer.getCustomerId());
        System.out.println("\t"+" your card number : "+ cardNumber );
	}

	public static String generateCardNumber() {
        Random rand = new Random();
        String cardNumber = "4"; // Visa card always starts with 4
        for (int i = 0; i < 17; i++) {
            int digit = rand.nextInt(10);
            cardNumber += digit;
        }
        return cardNumber;
    }
    
	
   

	public void login() {
        boolean isLoggedIn = false;
        int attempts = 0;

        do
        {
          System.out.print("Enter your customer Id: ");

          customerId = scanner.nextInt();
          Customer customer1 = customerService.findCustomerById(customerId);
      if (customer1!=null)
          {
            System.out.print("Enter your password: ");
            password = scanner.next();
            if (password.equalsIgnoreCase(password)) 
            {
              Customer customer = customerService.loginCustomer(customerId, password);

              if (customer == null) 
              {
                System.out.println("Invalid customer  password. Please try again.");
                attempts++;
              } 
                else {
                System.out.println("\nWelcome " + customer.getCustomerName() + "!");
                isLoggedIn = true;
                System.out.println("Welcome to grocery shop!");
                productUser.inputDisplayAllProducts();
                }
               
              }
            else 
              {
            	  System.out.println("Invalid password");
              }

       }else 
        {
        	System.out.println("Invalid Customer Id! please register yourself");
        	
        	
        }
//            
            } while (!isLoggedIn && attempts < 3);

            if (!isLoggedIn) {
              System.out.println("Too many attempts. Please try again later.");
            }
          }

}
