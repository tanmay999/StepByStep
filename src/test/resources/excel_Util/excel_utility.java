package excel_Util;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class excel_utility {
	public static XSSFWorkbook workbook ;
	public static XSSFSheet sheet;
	
	
	


public  excel_utility(String path, String sheet_name){
		
		 try {
			 String url= System.getProperty("user.dir")+path;
			workbook = new XSSFWorkbook(url);
			 sheet= workbook.getSheet(sheet_name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	
	
	public static Object get_cell_data(int row,int col) {			
		DataFormatter formatter = new DataFormatter();
		Object val=formatter.formatCellValue(sheet.getRow(row).getCell(col));	
		return val;
	}
	
	
	
	
	
	public static int  getRowCount() {
		
		int row_count=sheet.getPhysicalNumberOfRows();
		return row_count;
		
	}
	
	

	public static int  getColCount() {
		
		int col_count= sheet.getRow(0).getLastCellNum();
		return col_count;
		
	}
	
	

}
