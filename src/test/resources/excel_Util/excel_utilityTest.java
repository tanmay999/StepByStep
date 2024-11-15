package utils.excel_Util;


import org.testng.annotations.DataProvider;

public class excel_utilityTest {


	@DataProvider(name="dataProvide1")
	public static Object[][] get_Array_data() {
		
		

		String workbook_path="/data/test_data1.xlsx";
		String sheet_name="sheet1";
		 int row_count,col_count;
		 
		   Object[][] data_obj ;
		
		utilities.excel_utility utils= new utilities.excel_utility(workbook_path,sheet_name);
		
	    row_count=	utils.getRowCount();
	    col_count=  utils.getColCount();
	    
	    
	    data_obj = new  Object[row_count-1][col_count];
	    for(int i=1;i<row_count;i++) {
	    	for(int j=0;j<col_count;j++) {
	    		
	    		data_obj[i-1][j] = utils.get_cell_data(i, j);
	    		System.out.println(data_obj[i-1][j]);
	    		
	    	}
	    }
	    
	    return data_obj;
	    
	    

	    
	    
	}
	
	
	
	
	

}
