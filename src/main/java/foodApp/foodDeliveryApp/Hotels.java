package foodApp.foodDeliveryApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import files.XlFiles;
public class Hotels extends XlFiles implements ConstValues{

	public String hotelXlsx(String name) throws Exception{
		
		      boolean contains1=hotelNames.containsKey(name);
			   if(contains1){
//                 System.out.println("Hotel is Available");
                  System.out.println("/************************** Menus  *******************/");
                  Map <String,List<String>> item= getSheet(name);
              	List<String>  list1=new ArrayList<String>();
              	List<String>  list2=new ArrayList<String>();
                   int max=0;
                  
                    for(String item1 :item.keySet()) {
                    	List<String>list=item.get(item1);
                         list1.add(item1);
                    	String price=list.get(1);
                    	list2.add(list.get(1));
                    	if(item1.length()>max) {
                    		max=item1.length();
                    	}
                 int value=max+2;
               
                    	 String formattedString = String.format("%-"+value+"s"+"%-"+value+"s", item1, price);
                         System.out.println(formattedString);

                    }
                     
                    System.out.println("/******************Thank u ***********************/");
                 return name;
		       }
			   else
		   return null;  
	   }
  
	public static void main(String[] args) throws Exception {
		Hotels t=new Hotels();
	System.out.println(	t.hotelXlsx("a2b"));

	}

}
