package files;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import foodApp.foodDeliveryApp.ConstValues;

public class XlFiles implements ConstValues {
	
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
	 public  List<Object> searchFood1(String filePath1,String sheetName) throws IOException {
		 List <Object> item=new ArrayList<>();
		  File f=new File(filePath1);
		   FileInputStream fr=new FileInputStream(f);
		   XSSFWorkbook wbk =new XSSFWorkbook(fr);
		   Sheet sh=wbk.getSheet(sheetName);
		   int totalRows=sh.getPhysicalNumberOfRows();
		   for (int i=0 ;i<totalRows ;i++)
		   { 
			   Row row=sh.getRow(i);
//			   int totalColumn=row.getLastCellNum();
//			   for(int j=0 ;j<totalColumn;j++) {
			   Cell cell =row.getCell(0);
			   Cell cell2 =row.getCell(1);
			   Cell cell3 =row.getCell(2);
			   item.add(GetCellValue(cell).toString()+"-"+GetCellValue(cell2).toString()+"-"+GetCellValue(cell3));
//			   }
		   }
		   fr.close();
		   wbk.close();
	return item; 
	    } 
	  public Sheet fileReader(String filePath1,String sheetName) throws IOException {
		  File f=new File(filePath1);
		   FileInputStream fr=new FileInputStream(f);
		   XSSFWorkbook wbk =new XSSFWorkbook(fr);
		   Sheet sh=wbk.getSheet(sheetName);
		   return sh;
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
	public List <Object> hotelNames;
	public List <Object> a2b;
	public List <Object> buhari;
	public List <Object> muniyandi;
	public List <Object> dhindukalThalapakati;
	public List <Object> vasanthaBavan;
	public List <Object> salemRR;
    public void XlFiless() throws IOException {
    	hotelNames=xlRead(FilePath,"hotelNames");
        a2b=searchFood1(FilePath,"a2b");
        buhari=searchFood1(FilePath,"buhari");
        muniyandi=searchFood1(FilePath,"muniyandi");
        dhindukalThalapakati=searchFood1(FilePath,"dhindukal thalapakati");
        vasanthaBavan=searchFood1(FilePath,"vasantha bavan");
        salemRR=searchFood1(FilePath,"salem rr");
    }
	 
	public static void main(String[] args) throws IOException ,Exception {
		// TODO Auto-generated method stub
		XlFiles xl=new XlFiles();
	System.out.println(xl.searchFood1(FilePath,"a2b"));
	
	}

}
