package com.sk.main;

import java.util.Scanner;

import com.sk.model.Account;
import com.sk.service.ATMService;

public class ATMMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ATMService service=new ATMService();
		System.out.println("===== ATM Simulation System =====");
		System.out.println("Enter Account Number:");
		long accNO=sc.nextLong();
		System.out.println("Enter pin:");
		int pin=sc.nextInt();
		
		Account acc=service.getLogin(accNO, pin);
		
		if(acc==null) {
			
			System.out.println("Invalid Details");
		}
		
		System.out.println("Welcome "+acc.getName());
		
		int EnterYourOption;
		do {
			System.out.println("1.Balance");
			System.out.println("2.Deposit");
			System.out.println("3.Withdraw");
			System.out.println("4.Exit");
			System.out.println("EnterYourOption:");
		    
			EnterYourOption=sc.nextInt();
			
			switch(EnterYourOption) {
			case 1:
				System.out.println("Balance: "+acc.getBalance());
				break;
			case 2:
				System.out.println("Amount: ");
				service.deposit(acc, sc.nextDouble());
				System.out.println("Deposit Successful");
				break;
			case 3:
				System.out.println("Amount: ");
				if(service.withdraw(acc, sc.nextDouble()))
					System.out.println("Withdraw Successful");
				else
					 System.out.println("Insufficient Balance");
				break;
			case 4:
				System.out.println("Thank You!");
				break;
				default:
					System.out.println("Invalid Option");
			}
		}while(EnterYourOption!=4);

	}

}
