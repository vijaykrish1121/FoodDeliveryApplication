package foodApp.foodDeliveryApp;
import java.util.Scanner;
public class Hotels {

	 String hotel1="a1";
	  String hotel2="a2";
	  String hotel3="a3";
	  String hotel4="a4";
 public void searchHotel(String hotelName) {
	
	if(hotelName.equalsIgnoreCase(hotel1) || hotelName.equalsIgnoreCase(hotel2) || hotelName.equalsIgnoreCase(hotel3) ||hotelName.equalsIgnoreCase(hotel4) ) {
		 System.out.println("Serached Hotel is Available");
	}
	else
		System.out.println("Searched Hotel is not Available");
 }
 public static void main (String args[]) {  
		Hotels hl = new Hotels();
		Scanner sc =new Scanner(System.in);
		System.out.print("enter hotel Name:");
		String hotelName=sc.nextLine();
		   
		  hl.searchHotel(hotelName);
	}
}
