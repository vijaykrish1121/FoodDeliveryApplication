package foodApp.foodDeliveryApp;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import files.XlFiles;
public class Hotels extends XlFiles implements ConstValues{
	   public Hotels() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public String hotelXlsx(String name) throws Exception{
		 //  List<Object> item=xlRead(FilePath,"hotelNames");
		      boolean contains=hotelNames.contains(name);
			   if(contains){
                 System.out.println("Hotel is Available");
                 return name;
		       }
			   else
		   System.out.println("Hotel is not Available");
		   return null;  
	   }
	   public void foodSheet() throws IOException {
		    List<Object> item=xlRead(FilePath,"a2b");
		    System.out.println(item);
	   }
	   
	public static void main(String[] args) throws Exception {
		Hotels t=new Hotels();
	System.out.println(	t.hotelXlsx("a2b"));
	t.foodSheet();
	}

}
