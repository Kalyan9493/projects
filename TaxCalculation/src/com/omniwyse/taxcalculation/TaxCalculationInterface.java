package com.omniwyse.taxcalculation;

public interface TaxCalculationInterface {
	public void esiCalculation(long ctc);
	public void pfCalculation(long ctc);
	public void ptCalculation(long ctc);
	public void incometaxCalculation(long ctc);
	public void rebate(long ctc);
	public void empNetSalary(long ctc);

}
