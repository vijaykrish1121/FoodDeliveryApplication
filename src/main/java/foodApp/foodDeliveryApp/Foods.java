package foodApp.foodDeliveryApp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Foods extends Hotels{
	  public Boolean searchFoods(String foodName,String hotelName) throws IOException {
		 Map <String,List<String>> item= getSheet(hotelName);
		   Boolean checkFood= item.containsKey(foodName);
		   return checkFood;
	  }
	  public double getQuantity(boolean checkFood,String foodName,double quantity,String sheetName) throws IOException{
		  double quantityAvailabe=0;
		  
		  if(checkFood) {
			  String itemName=foodName;
			  Map <String,List<String>> item= getSheet(sheetName);
			   List<String> list=item.get(itemName);
			       //  System.out.println(list.get(0)); 
			          quantityAvailabe =Double.parseDouble(list.get(0));
        
	  }
		  return quantityAvailabe;
	  }
	  
	  public double getPrice(boolean checkFood,String foodName,String sheetName) throws IOException
	  {
		  double price=0;
		  if(checkFood)
		  {
			   String itemName=foodName;
			   Map<String,List<String>> item=getSheet(sheetName);
			   List <String> list=item.get(itemName);
			    price=Double.parseDouble(list.get(1));  
		  }
		  return price;
	  }
	  
	public Map<String,List<String>> getSheet(String sheetName) {
	Map<String,List<String>> item =null;
		   if(sheetName.equalsIgnoreCase("hotelNames")) {   
				 item=hotelNames;
			   }
		   else if(sheetName.equalsIgnoreCase("a2b")) {
			    item=a2b;
			   }
			   else if(sheetName.equalsIgnoreCase("buhari")) {
			     item=buhari;
			   }
			   
			   else if(sheetName.equalsIgnoreCase("salem rr")) {
				    item=salemRR;
				     }
			   else if(sheetName.equalsIgnoreCase("vasantha bavan")) {
				    item=vasanthaBavan;
				     }
			   else if(sheetName.equalsIgnoreCase("muniyandi")) {
				    item=muniyandi;
				     }
			   else if(sheetName.equalsIgnoreCase("dhindukal thalapakati")) {
				  item=dhindukalThalapakati;
				     }
		  return item;
	}	  
	  public double foodQuantity(String foodName,String value,double givenQuantity) throws IOException {
		 double quantity=0;
		   String[] values=value.split("-");
		  quantity=Double.parseDouble(values[0]);
		 if(givenQuantity<quantity) {
			 System.out.println("Quantity of food is Available");
		 return quantity;
		 }
		 else
			 System.out.println("Quantity of Food is Not Available");
		 return 0;
		  
	  }
	  public double foodPrice(String foodName,String value) {
		  String[] values=value.split("-");
		  double price=Double.parseDouble(values[1]);
		  return price;
	  }
	 

 public static void main (String args[]) throws NullPointerException, Exception {

 }
}
