package foodApp.foodDeliveryApp;
import java.io.IOException;
import java.util.Scanner;
import billing.Invoice;
public class HomePage extends Invoice {

public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


		//	public void findHotel() throws Exception {
//		
//		 Scanner sc=new Scanner(System.in);
//	        HomePage hp=new HomePage();
//	        System.out.println("Enter hotelName");
//	        String hotelName=sc.nextLine();
//	        String searchedHotelName=hp.hotelXlsx(hotelName); 
//	        if(searchedHotelName !=null) {
//	        System.out.println("Search Food");
//	        String foodName=sc.nextLine(); 
//	        int foodRow= hp.searchFood(foodName,searchedHotelName);
//	        if(foodRow>0 || foodRow !=0) {
//	        double amount=hp.getPrice(foodRow,searchedHotelName);
//	        System.out.println("Enter Quantity");
//	        int quantity=sc.nextInt();
//	        double checkQuantity=hp.getQuantity(foodRow, searchedHotelName, quantity);
//	        if(checkQuantity !=0){
//	          calculateToalPrice(amount,checkQuantity);
//	        }
//	        }
//	        }
//	          sc.close();
//	}
		public void findHotel() throws Exception {
		
		 Scanner sc=new Scanner(System.in);
	        HomePage hp=new HomePage();
	        System.out.println("Enter hotelName");
	        String hotelName=sc.nextLine();
	        String searchedHotelName=hp.hotelXlsx(hotelName); 
	        if(searchedHotelName !=null) {
	        System.out.println("Search Food");
	        String foodName=sc.nextLine(); 
	        String searchFood=hp.searchFoods(foodName,searchedHotelName);
	         if(searchFood !=null) {
	        	 System.out.println("Enter Quantity"); 
	         double quantity=sc.nextDouble();
	         double checkQuantity=hp.foodQuantity(foodName, searchFood, quantity);
	         double amount=hp.foodPrice(foodName, searchFood);
	        	      if(checkQuantity !=0) {
	        	    	  calculateTotalPrice(amount,quantity);
	        	      }
	        			 }
	        }
		}
		 
		
	 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    HomePage hp=new HomePage();
	    hp.findHotel();
	}

}
