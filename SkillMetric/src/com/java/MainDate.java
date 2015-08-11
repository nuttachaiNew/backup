package com.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainDate {
	public static void main(String[] args) {
		
	

	      Date dNow = new Date( );
	      SimpleDateFormat ft1 = new SimpleDateFormat ("yyyy/MM/dd");
	      SimpleDateFormat ft2 = new SimpleDateFormat("HH:MM:SS");
	 	      System.out.println(dNow.toString());
	      	  System.out.println(ft1.format(dNow));	
	 	      System.out.println(ft2.format(dNow));	
	}
}
