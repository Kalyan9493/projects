package atmWorking;

import java.util.Scanner;

public class Operations implements ATMProcedure{

	private Scanner s;
	@Override
	public void showBalance(int amount) {
		System.out.println("Your Account Balance is:"+amount);
	}

	public int withdrawAmount(int amount) {
		System.out.println("Enter The Amount You Want To Withdraw:");
		s = new Scanner(System.in);
		int withdrawamount=s.nextInt();
		if(withdrawamount>amount) {
			System.out.println("InSufficient Balance");
		}
		else {
			amount=amount-withdrawamount;
			System.out.println("Remaining Balance Is:"+amount);
		}
		return amount;
		
	}

	@Override
	public void showRemainingBalance(int amount) {
		
		System.out.println("Remaining Balance Is:"+amount);
		
	}

}
