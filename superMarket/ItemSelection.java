package superMarket;

import java.util.Scanner;

import org.slf4j.LoggerFactory;

public abstract class ItemSelection implements SuperMarket{
	
	/**
	 * rice1,dal1,flour1, are the fields that stores the values given by the user.
	 * 
	 */

	private Scanner s;
	public static float rice1;
	public static float dal1;
	public static float flour1;
	
	final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(ItemSelection.class);
	
	/**
	 * Display() function displays the product with their prices.
	 */
	public void display() {
		System.out.println("1.Rice\t 40 per KG\n2.Dal\t 60 per KG\n3.Flour\t 80 per KG");
		
	}
	
	/**
	 * selectRice() function used to take the input of rice in Kg's from the user
	 * and stores in rice1 variable.
	 */
	public float selectRice() {
		System.out.println("Enter Rice You Want(in kg's):");
		s = new Scanner(System.in);
		rice1 = s.nextInt();
		return rice1;
		
	}
	/**
	 * selectDal() function used to take the input of dal in Kg's from the user
	 * and stores in dal1 variable. 
	 */
	public float selectDal() {
		System.out.println("Enter Dal You Want(in kg's):");
		s = new Scanner(System.in);
		dal1 = s.nextInt();
		return dal1;
		
	}
	/**
	 * selectFlour() function used to take the input of Flour in Kg's from the user
	 * and stores in flour1 variable. 
	 */
	public float selectFlour() {
		System.out.println("Enter Flour You Want(in kg's):");
		s = new Scanner(System.in);
		flour1 = s.nextInt();
		return flour1;
		
	}
	/**
	 * bill() takes the input of rice, dal and flour and calculates the bill.
	 * if bill > 500 it gives 10% discount.
	 * if bill > 1000 it gives 20% discount.
	 */
	public void bill(float rice1,float dal1,float flour1) {
		float bill=rice1+dal1+flour1;
		if(bill>500 && bill <1000) {
			System.out.println("Cost for Rice is:"+rice1);
			System.out.println("Cost for Dal is:"+dal1);
			System.out.println("Cost for Flour is:"+flour1);
			System.out.println("Discount for your Bill is:"+(bill*0.1));
			System.out.println("Total Bill is:"+(bill-(bill*0.1)));
			LOGGER.info("Your bill is greater than the 500 so you get 10% discount");
		}
		if(bill>1000) {
			System.out.println("Cost for Rice is:"+rice1);
			System.out.println("Cost for Dal is:"+dal1);
			System.out.println("Cost for Flour is:"+flour1);
			System.out.println("Discount for your Bill is:"+(bill*0.15));
			System.out.println("Total Bill is:"+(bill-(bill*0.15)));
			LOGGER.info("Your bill is greater than the 1000 so you get 15% discount");
			
		}
		else {
			LOGGER.info("Your bill is less than the 500 so you didn't get any discount");
			System.out.println("Total Bill is:"+bill);
		}
	}


}
