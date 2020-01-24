package com.omniwyse.taxcalculation;

public class TaxCalculation implements TaxCalculationInterface{
	
	private static double netsalary;
	private static float pf;
	private static float pt;
	private static double tax;
	private static float esi;
	private static float rebate;

	
	// pfCalculation method calculates the pf from salary

	public void pfCalculation(long ctc) {//pf calculation from 12% of salary
		pf= (float) (ctc*0.12);
		System.out.println("Employee PF per year is:"+pf+"\n");
		
		
		
	}

	public void ptCalculation(long ctc) {// this function calculates professional tax
		if((ctc/12)<15000) {
			pt=0;
		}
		if((ctc/12)>15000  && (ctc/12)<20000) {
			pt=150;
		}
		if((ctc/12)>20000) {
			pt=200;
			
		}
		pt=pt*12;
		System.out.println("Employee PT per year is:"+pt+"\n");
		

	}

	public void incometaxCalculation(long ctc) {// this function calculates the income tax
		if(ctc<250000) {
			tax=0;
		}
		else if(ctc>250000 && ctc<=500000) {
			tax=(ctc-250000)*(5/100);
		}
		else if(ctc>500000 && ctc<=1000000) {
			
			tax=12500+((ctc-500000)*20/100);
			
		}
		else {
			tax=12500+100000+((ctc-1000000)*30/100);
		}
		System.out.println("Income Tax is:"+tax+"\n");
		
	}

//this function clculates the rebate. if ctc lessthan 3.5 lakhs rebate=1500,if ctc lessthan 5 lakhs rebate=5000.
	// this is according to section 87A
	public void rebate(long ctc) {
										
		if(ctc<=350000) {
			rebate=1500;
		}
		
		
		if(ctc>350000 && ctc<=500000) {
			rebate = 5000;
			
		}
		System.out.println("Rebate amount is"+rebate+"\n");

	}
// this function calculates esi from salary.
	// esi is calculated 1.75% from salary. 
	public void esiCalculation(long ctc) {
		
		if((ctc/12)>21000) {
			
			esi=(float) ((ctc/12)*(0.75/100));
			esi=esi*12;
			System.out.println("Employee ESI per year is: "+esi+"\n");
			
		}
		

		
	}
	
	// this function gives net annual an monthly net salary.
	@Override
	public void empNetSalary(long ctc) {
		
		netsalary=(ctc-esi-pf-pt-tax+rebate);
		System.out.println("Employee Net Salary Per Annum Is:"+netsalary+"\n");
		System.out.println("Employee Net Salary Per per month is:"+(netsalary/12));
		
	}

}
