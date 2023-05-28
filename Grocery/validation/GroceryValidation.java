package com.gms.jpa.validation;

import java.util.Random;
import java.util.regex.Pattern;

public class GroceryValidation {

	 public static boolean validateName(String productName)
	    {
	        String nameRegex = "^[A-Za-z]+$";
	        Pattern pattern = Pattern.compile(nameRegex);
	        return pattern.matcher(productName).matches();
	    }
	    
	    public static boolean validatePrice(int price)
	    {
	        return price > 0;
	    }
	    
	    public static boolean validateStock(Integer stock)
	    {
	        return stock > 0;
	    }
	    
	    public static boolean validateQuantity(Integer quantity) 
	    {
	        return quantity > 0;
	    }

		public static boolean validateEmail(String email) {
			 String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$";
			    Pattern pattern = Pattern.compile(emailRegex);
			    return pattern.matcher(email).matches();
		}

		public static boolean validateMobile(CharSequence contactNumber) {
			 String mobileNoRegex = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$";
		        Pattern pattern = Pattern.compile(mobileNoRegex);
		        return pattern.matcher(contactNumber).matches();
		}

		public static boolean validatePassword(String password) {
			 if (password == null || password.length() < 8) {
		            return false;
		        }
		        
		        boolean hasUppercase = false;
		        boolean hasLowercase = false;
		        boolean hasDigit = false;
		        boolean hasSpecialChar = false;
		        
		        for (char ch : password.toCharArray()) {
		            if (Character.isUpperCase(ch)) {
		                hasUppercase = true;
		            } else if (Character.isLowerCase(ch)) {
		                hasLowercase = true;
		            } else if (Character.isDigit(ch)) {
		                hasDigit = true;
		            } else {
		                hasSpecialChar = true;
		            }
		        }
		        
		        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
		}

		public static boolean validateCardAmount(Integer cardAmount) {
		    if(cardAmount >= 2000 && cardAmount <= 10000) {
		        return true;
		    }
		    return false;
		}

		public static boolean validateCardNumber(String cardNumber) {
	        int sum = 0;
	        boolean alternate = false;
	        for (int i = cardNumber.length() - 1; i >= 0; i--) {
	            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
	            if (alternate) {
	                n *= 2;
	                if (n > 9) {
	                    n = (n % 10) + 1;
	                }
	            }
	            sum += n;
	            alternate = !alternate;
	        }
	        return (sum % 10 == 0);
	    }

	
	
}


