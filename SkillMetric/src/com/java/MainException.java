package com.java;

import java.util.Scanner;

public class MainException {

	public static void main(String[] args)throws Except {
		// TODO Auto-generated method stub
		 Scanner input = new Scanner( System.in );
		 String telNo;
		 String checkNo;
		 System.out.print("Enter your telephone no:");
		 telNo=input.nextLine();
		 checkNo=telNo.substring(0, 2);
		 if(checkNo.equals("08")){
			 System.out.println("Your telphone :"+telNo);
		 }else{
			 throw new Except(checkNo);
		 }
		
		
	}

}
