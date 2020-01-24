package atmWorking;

import java.util.Scanner;

public class Test {
	private static Scanner s;
	private static char c2;
	public static int amount;

	public static void main(String args[]) {
		
		Operations op=new Operations();
		
	System.out.println("Enter Account Balance:");
	s = new Scanner(System.in);
	 amount=s.nextInt();
	
	do {
			System.out.println("Enter 1 for Show Balance\nEnter 2 for Withdraw Amount\nEnter 3 for Show Remaining Balance");
			int value=s.nextInt();
			switch(value) {
		
			case 1:	op.showBalance(amount);
				break;
			case 2: amount=op.withdrawAmount(amount);
				break;
			case 3: op.showRemainingBalance(amount);
				break;
			default : System.out.println("INVALID ENTRY");
			}
		System.out.println("Do You Want To Continue y/n:");
		c2 = s.next().charAt(0);
	}while(c2!='n');
	

	}
}