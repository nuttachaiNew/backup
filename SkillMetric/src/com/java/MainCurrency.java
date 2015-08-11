package com.java;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
public class MainCurrency {
	public static void main(String[] args) {
		 Locale locale = Locale.JAPAN;
		 Locale locale2 = Locale.US;
		 Currency curr = Currency.getInstance(locale);
		 String symbol = curr.getSymbol(locale);
		 double amount =100000;
		 
		 System.out.println("Locale's currency code : " + curr.getCurrencyCode());	 
		 
		 NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		 NumberFormat currencyFormatter2 = NumberFormat.getCurrencyInstance(locale2);
		 
		 System.out.println(currencyFormatter.format(amount));
		 System.out.println(currencyFormatter2.format(amount));
		 
	
	}

	
}		

