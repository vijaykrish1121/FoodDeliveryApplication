package foodApp.foodDeliveryApp;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Foods extends Hotels{
public Foods() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	//	  public int searchFood(String foodName,String hotelName) throws Exception,NullPointerException{
//		  int count=0;
//		  if(hotelName!=null) { 
//		   Sheet sh=fileReader(FilePath,hotelName);
//		   int totalRows=sh.getPhysicalNumberOfRows();
//		   for (int i=0 ;i<totalRows ;i++)
//		   { 
//			   Row row=sh.getRow(i);
//			   int totalColumn=row.getLastCellNum();
//			   for(int j=0 ;j<totalColumn;j++) {
//			   Cell cell =row.getCell(j);
//			   Object item=GetCellValue(cell);
//			   if(foodName.equalsIgnoreCase(item.toString())) {
//				  count=i;
//				  System.out.println("Food is Available"); 
//			   }
//			   }
//		   }
//		  }
//		  else
//		  System.out.println("Food is not Available");
//		  return count;  
//	  }
	  public String searchFoods(String foodName,String hotelName) throws IOException {
		 String name=null;
		 List<Object> item=null;
		   if(hotelName.equalsIgnoreCase("a2b")) {
			   item=a2b;
		   }
		   else if(hotelName.equalsIgnoreCase("buhari")) {
		     item=buhari;
		   }
		   
		   else if(hotelName.equalsIgnoreCase("salem rr")) {
			     item=salemRR;
			     }
		   else if(hotelName.equalsIgnoreCase("vasantha bavan")) {
			     item=vasanthaBavan;
			     }
		   else if(hotelName.equalsIgnoreCase("muniyandi")) {
			     item=muniyandi;
			     }
		   else if(hotelName.equalsIgnoreCase("dhindukal thalapakati")) {
			     item=dhindukalThalapakati;
			     }
		   
		// List< Object> item=searchFood1(FilePath,hotelName);
		   for(Object list :item) {
			  String[] row=list.toString().split("-");
			 // System.out.print(row[0]);
			  if(row.length>0) {
				   if(foodName.equalsIgnoreCase(row[0])) {
					  System.out.println("Food is Available"); 
				     name=row[1]+"-"+row[2];
					return name;
				   }
				 
			  }
			  
		   }
			   System.out.println("Food is Not Available");
			  return null;
			   
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
	 
//	  public double getPrice(int count,String hotelName) throws Exception {
//		  double price=0;
//		  if(count>0 || count!=0) {
//		   Sheet sh=fileReader(FilePath,hotelName);
//		   Cell cell2 = null;
//			   Row row =sh.getRow(count);
//			   cell2=row.getCell(2);
//		  price=cell2.getNumericCellValue();   
//	   }
//	
//		  return price;
//	  }
//	  public double getQuantity(int count,String hotelName,double userQuantity) throws Exception {
//		 double quantity=0;
//		 double userQuantity1=0;
//		  if(count>0 || count!=0) {
//			  Sheet sh=fileReader(FilePath,hotelName);
//			   Cell cell1 = null;
//			   Row row =sh.getRow(count);
//				   cell1=row.getCell(1);
//			  quantity= cell1.getNumericCellValue();
//			  if(userQuantity>quantity) {
//				  System.out.println("Quantity of food is not Available");
//				  userQuantity=0;
//			  }
//			  else
//				  System.out.println("quantitiy is Available");
//			  userQuantity1=userQuantity;
//		   }
//		  return userQuantity1;
//	  }

 public static void main (String args[]) throws NullPointerException, Exception {
//	   Scanner sc=new Scanner(System.in);
//	   System.out.println("enter food");
//	   String foodName=sc.nextLine();
   Foods fd=new Foods();
	  
	 //   fd.searchFoods("dhosa");
//	    System.out.println(fd.searchFoods("dhosa"));
	  System.out.println(fd.foodQuantity("dhosa","3.0-35.0",2.0));
 }
}
