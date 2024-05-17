package foodApp.foodDeliveryApp;
import java.io.IOException;
import java.util.Scanner;
import billing.Invoice;
import files.XlFiles;
public class HomePage extends Invoice {

        public static  void findHotel() throws Exception {  
		 @SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
	        HomePage hp=new HomePage();
	        System.out.println("Enter hotelName");
	        String hotelName=sc.nextLine();
	        String searchedHotelName=hp.hotelXlsx(hotelName); 
	        if(searchedHotelName !=null) {
	        System.out.println("Hotel is Available");
	        System.out.println("Search Food in the Menu List");
	        String foodName=sc.nextLine(); 
	        boolean searchFood=hp.searchFoods(foodName,searchedHotelName);
	        if(searchFood) {
	        System.out.println("Food is Available");
	        	 System.out.println("Enter Quantity"); 
	         double quantity=sc.nextDouble();
	         double Quantity=hp.getQuantity(searchFood,foodName,quantity,searchedHotelName);
	         if(Quantity >quantity) {
	        	  System.out.println("Quantity is available");
	         double amount=hp.getPrice(searchFood,foodName,searchedHotelName);
	        	    	  calculateTotalPrice(amount,quantity);	  
	        	    	  System.out.println("**********ORDER PLACED SUCESSFULLY***************");
	        	      }
	         else
	        	 System.out.println("Quantity is not available Available Quantity is  "+Quantity); 
	        }
	        else
        		System.out.println("Food is not Available Search Available Food in the Menu List");
	        
		}
	        else
	        	 System.out.println("Hotel is Not Available");
        }
	        
 

	 
	public static void main(String[] args) throws Exception{

	     Thread t=new Thread () {
	    	  XlFiles xl=new XlFiles();
	    	 public void run() {
	    		  try {
					xl.XlFiless();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	 }	
	     };
	     t.start(); 
	     t.join();
	     Thread t1=new Thread () {
	    	 public void run() {
	    		  try {
				findHotel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	 }	
	     };  
	     t1.start();

	}
}
