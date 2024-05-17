package files;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import foodApp.foodDeliveryApp.ConstValues;

public class XlFiles extends Thread implements ConstValues {
	
	 public  List<Object> xlRead(String filePath1,String sheetName) throws IOException {
		 List <Object> item=new ArrayList<>();
		  File f=new File(filePath1);
		   FileInputStream fr=new FileInputStream(f);
		   XSSFWorkbook wbk =new XSSFWorkbook(fr);
		   Sheet sh=wbk.getSheet(sheetName);
		   int totalRows=sh.getPhysicalNumberOfRows();
		   for (int i=0 ;i<totalRows ;i++)
		   { 
			   Row row=sh.getRow(i);
			   int totalColumn=row.getLastCellNum();
			   for(int j=0 ;j<totalColumn;j++) {
			   Cell cell =row.getCell(j);
			   item.add(GetCellValue(cell));
			   }
		   }
		   fr.close();
		   wbk.close();
	return item; 
	    } 
	 public  Map<String,List<String>> searchFood1(String filePath1,String sheetName) throws IOException {
		
		 Map <String,List<String>> item=new LinkedHashMap<>();
		  File f=new File(filePath1);
		   FileInputStream fr=new FileInputStream(f);
		   XSSFWorkbook wbk =new XSSFWorkbook(fr);
		   Sheet sh=wbk.getSheet(sheetName);
		   int totalRows=sh.getPhysicalNumberOfRows();	  
		   String key=null;
		   for (int i=0 ;i<totalRows ;i++)
		   { 
			   List <String> value=new ArrayList<>();
			   Row row=sh.getRow(i);
			   Cell cell =row.getCell(0);
			   Cell cell2 =row.getCell(1);
			   Cell cell3 =row.getCell(2);
			     key=GetCellValue(cell).toString();		    
			    value.add(GetCellValue(cell2).toString());
			    value.add(GetCellValue(cell3).toString());
			    item.put(key,value);	 
		   }
		   fr.close();
		   wbk.close();
	     return item; 
	    } 
	  public Sheet fileReader(String filePath1,String sheetName) throws IOException {
		  File f=new File(filePath1);
		   FileInputStream fr=new FileInputStream(f);
		   @SuppressWarnings("resource")
		XSSFWorkbook wbk =new XSSFWorkbook(fr);
		   Sheet sh=wbk.getSheet(sheetName);
		   return sh;
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
	 public Object GetCellValue(Cell cell)
		{
		   if(cell==null) {
			   return "";
		   }
		
		    if (cell.getCellType() == CellType.STRING) {
	            return cell.getStringCellValue();
	        }
		    else if (cell.getCellType() == CellType.NUMERIC) {
	            // Handle numeric cell value
	            return cell.getNumericCellValue();
	            
	        } 
	        else 
				{
					DataFormatter data =  new DataFormatter();
					return data.formatCellValue(cell);
					//return cellVal.getNumericCellValue();
				}
	       
		}
	 public static Map <String,List<String>> hotelNames=new HashMap<>();
	public static Map <String,List<String>> a2b=new HashMap<>();
	public static Map <String,List<String>> buhari=new HashMap<>();
	public static Map <String,List<String>> muniyandi=new HashMap<>();
	public static Map <String,List<String>> dhindukalThalapakati=new HashMap<>();
	public static Map <String,List<String>> vasanthaBavan=new HashMap<>();
	public static Map <String,List<String>> salemRR=new HashMap<>();
	
	 public void XlFiless() throws IOException {	
         hotelNames=searchFood1(FilePath,"hotelNames");  
         a2b=searchFood1(FilePath,"a2b");
        buhari=searchFood1(FilePath,"buhari");
      muniyandi=searchFood1(FilePath,"muniyandi");
      dhindukalThalapakati=searchFood1(FilePath,"dhindukal thalapakati");
       vasanthaBavan=searchFood1(FilePath,"vasantha bavan");
     salemRR=searchFood1(FilePath,"salem rr");
    	
   }
	  
	public static void main(String[] args) throws IOException ,Exception {
     
	}

}
