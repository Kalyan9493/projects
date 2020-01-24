package com.omniwyse.taxcalculation;

import java.util.Scanner;

public class TestTax {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		TaxCalculation tci= new TaxCalculation();
		
		System.out.println("Enter CTC of employee:");
		sc = new Scanner(System.in);
		long ctc=sc.nextInt();
		 tci.pfCalculation(ctc);
		 tci.ptCalculation(ctc);
		 tci.incometaxCalculation(ctc);
		 tci.rebate(ctc);
		 tci.empNetSalary(ctc);
	}

}
