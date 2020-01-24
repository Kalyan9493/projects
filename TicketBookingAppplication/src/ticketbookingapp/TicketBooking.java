package ticketbookingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TicketBooking {

    public static Connection con;
    public static Statement st;
    Scanner s = new Scanner(System.in);
	TicketDetils ticketDetails = new TicketDetils();
	public static void main(String[] args) {
		String username, password;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter The Username:");
		username = s.nextLine();
		System.out.print("Enter The Password:");
		password = s.nextLine();
		if (isAuthorisedUser(username,password)) {
			TicketBooking ts = new TicketBooking();
			dbconnection(); 
			ts.startBooking();
		} else {
			System.out.println("Authentication Failed!");
		}

	}

	public static boolean isAuthorisedUser(String userName, String password) {
		if (userName.equals("admin") && password.equals("admin"))
			return true;
		else
			return false;
	}
	int seats=0;
	public void startBooking() {
		
		chooseTravelWay();
		System.out.print("\nEnter seats you want:");
		int seats =s.nextInt();
		bookSeats(0,0,seats);
	}
	
	public void bookSeats(int id,int seatsBooked, int seatsPending) {
		Scanner s = new Scanner(System.in);
		int seats = seatsBooked+seatsPending;
		int seatId=allocateSeat();
		
		if(seatId>100) {
			System.out.println("No seats available...");
		}
		else {
		if (seats <= (100-seatId)) {
			int i;
			for(i=id;i<seats;i++) {
				System.out.println("\nEnter details of person "+(i+1)+" : ");
				Person p1 = new Person();
				System.out.print("Name of Passenger:");
				p1.setName(s.nextLine());
				boolean retry=false;
				do {
				try {
					System.out.print("Age of Passenger: ");
					int age=s.nextInt();
					if(age>0 && age<120) {
						p1.setAge(age);
						retry=false;
					}
					else {
						
						retry=true;
						s.nextLine();
						System.out.println("Age should be in between 1-120");
					}
				}catch(Exception e) {
					retry=true;
					s.nextLine();
					System.out.println("Please Enter Number");
				}
				}while(retry);
				s.nextLine();
				
				p1.setSeatId("S"+seatId);
				seatId++;
				
				System.out.print("Gender of Passenger: ");
				p1.setGender(s.nextLine());
				System.out.println();
				this.ticketDetails.listOfPeople[i]=p1;
			}
			this.calculateTotalFair(seats);
			System.out.println("Total Fair: "+this.ticketDetails.getTotalFair());
			System.out.print("\nDo you want to proceed for Payment(Y/N):");
			String proceed = s.nextLine();
			if(proceed.equalsIgnoreCase("Y")) {
				ticketDetails.setPayMethod(choosePaymentMethod());
		
				try {
					st = con.createStatement();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("Name\t\tAge\tGender\tFrom\tTO\tPaymentMethod\tBerth");
				for(int j=id;j<seats;j++) {
					Person p = ticketDetails.listOfPeople[j];
					System.out.println(p.getName()+"\t\t"+p.getAge()+"\t"+p.getGender()+"\t"+this.ticketDetails.getFromCity()+"\t"+this.ticketDetails.getToCity()+"\t"+this.ticketDetails.getPayMethod()+"\t\t"+p.getSeatId());
					String sql1="insert into bookings(name,age,gender,fromstation,tostation,fare,paymentmethod,berth) values ('"+p.getName()+"','"+p.getAge()+"','"+p.getGender()+"','"+this.ticketDetails.getFromCity()+"','"+this.ticketDetails.getToCity()+"','"+this.ticketDetails.getTicketAmount()+"','"+this.ticketDetails.getPayMethod()+"','"+p.getSeatId()+"')";
					try {
					st.execute(sql1);
					System.out.println("Tickets  Booked..");
					} catch (SQLException e) {
						e.printStackTrace();
					}
			
				}
			}
			System.out.print("\nDo you want to repeat process Again(Y/N):");
			String repeat = s.nextLine();
			if(repeat.equalsIgnoreCase("y")) {

				continueBooking(i,seats);
			}
			System.out.print("\nDisplay Prepared Chart(Y/N):");
			String repeat1 = s.nextLine();
			if(repeat1.equalsIgnoreCase("y")) {

				preparedChart();
			}
			
			
		}
		else{
			System.out.println("You are not allowed to book more than "+(100-seatId)+" seats");
			if(id == 0)
			startBooking();
			else
				System.out.println("Only "+(100-seatId)+" seats are remained!!");
				continueBooking(id, seatsBooked);
		}
		}
		
	}
	private String choosePaymentMethod() {
		Scanner s = new Scanner(System.in);
		boolean retry=false;
		int input = 0;
		do {
			try {
				System.out.println("1.Cash\n2.cheque\n3.voucher\n4.credit/debit");
				input = s.nextInt();
				retry=false;
		}catch(Exception e) {
			retry=true;
			s.nextLine();
			System.out.println("Please Enter number");
			
		}
		}while(retry);
		String paymethod = "";
		switch(input) {
		case 1:paymethod="cash";
			break;
		case 2:paymethod="cheque";
			break;
		case 3:paymethod="voucher";
			break;
		case 4:paymethod="credit/debit";
			break;
		default:System.out.println("INVALID OPTION");
		}
		return paymethod;
		
	}

	private void calculateTotalFair(int seats) {
		ticketDetails.setTotalFair(this.ticketDetails.getTicketAmount()*seats);
		
	}

	public void continueBooking(int id,int seatsbooked) {
		Scanner s = new Scanner(System.in);
		System.out.println("\nEnter no of seats:");
		int seats = s.nextInt();
		bookSeats(id,seatsbooked,seats);
		
	}
	
	public void chooseTravelWay() {
		Scanner s = new Scanner(System.in);
		String fromCity = "";
		String toCity = "";
		System.out.println("1. hyd to vizag");
		System.out.println("2. hyd to kbs");
		System.out.println("3. hyd to delhi");
		System.out.print("Choose your option: ");
		
		boolean retry=false;
		int option=0;
		do {
			try {
				option = s.nextInt();
				retry=false;
			}catch(Exception e) {
				retry=true;
				s.nextLine();
				System.out.println("Please Enter Number");
			}
		}while(retry);
		switch(option) {
		case 1: 
			fromCity = "hyd";
			toCity = "vizag";
			break;
		case 2:
			fromCity = "hyd";
			toCity = "kbs";
			break;
		case 3:
			fromCity = "hyd";
			toCity = "delhi";
			break;
		default:
			System.out.println("Invalid Input!!");
			chooseTravelWay();	
		}
		getPersonFair(fromCity,toCity);
	}
	
	public void getPersonFair(String fromCity,String toCity) {
		if(fromCity.contentEquals("hyd") && toCity.equals("vizag") ) {
			this.ticketDetails.setTicketAmount(400);
		}
		else if(fromCity.contentEquals("hyd") && toCity.equals("kbs") ) {
			this.ticketDetails.setTicketAmount(450);
		}
		else if(fromCity.contentEquals("hyd") && toCity.equals("delhi") ) {
			this.ticketDetails.setTicketAmount(1120);
		}
		this.ticketDetails.setFromCity(fromCity);
		this.ticketDetails.setToCity(toCity);
	}
	public static void dbconnection(){
		
		String url="jdbc:mysql://localhost:3306/bookinginfo";
		String uname="collectionadmin";
		String pass="collectionadmin";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,uname,pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void preparedChart() {
		ResultSet rs;
		try {
			 rs=st.executeQuery("select name,age,gender,fromstation,tostation,fare,paymentmethod,berth  from bookings;");
		
			 System.out.println("Name\t\tAge\tGender\tFrom\tTo\tFare\tPaymentMethod\tBerth");
			 while(rs.next()) {
				 String name=rs.getString("name");
				 int age=rs.getInt("age");
				 String gender=rs.getString("gender");
				 String fromstation=rs.getString("fromstation");
				 String tostation=rs.getString("tostation");
				 float fare=rs.getFloat("fare");
				 String paymentmethod=rs.getString("paymentmethod");
				 String berth=rs.getString("berth");
				 System.out.println(name+"\t\t"+age+"\t"+gender+"\t"+fromstation+"\t"+tostation+"\t"+fare+"\t"+paymentmethod+"\t\t "+berth);	
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static int allocateSeat()
	{
		String sql="SELECT * FROM bookings ORDER BY id DESC LIMIT 1;";
		int id = 0;
		try {
			Statement st= TicketBooking.con.createStatement();
			ResultSet r=st.executeQuery(sql);
			
			while(r.next()) {
				id=r.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;	
	}

}
class Person{
	private String seatId;
	private String name;
	private int age;
	private String gender;
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
class TicketDetils{
	private String fromCity;
	private String toCity;
	private int ticketAmount;
	public Person[] listOfPeople=new Person[100];
	private int totalFair;
	private String payMethod;
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public int getTicketAmount() {
		return ticketAmount;
	}
	public void setTicketAmount(int ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
	public int getTotalFair() {
		return totalFair;
	}
	public void setTotalFair(int totalFair) {
		this.totalFair = totalFair;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
}

