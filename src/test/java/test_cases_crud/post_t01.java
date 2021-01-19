package test_cases_crud;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utilities.excel_utilityTest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class post_t01  extends  excel_utilityTest{
	
    
	@DataProvider(name="test_data")
	public Object[][]  provide()
	{
		Object[][] data =get_Array_data();
		
		 for(int i=0;i<data.length;i++) {
		    	for(int j=0;j<data[0].length;j++) {
		    		
		    		
		    		System.out.println(data[i][j]);
		    		
		    	}
		    }
		return data;
		
		
		
	}
	
	
	/*public Object[][] provide(){
		
	Object[][]  data_excel = new Object[3][2];
		data_excel[0][0]    = "tan";
		data_excel[0][1]    ="cricketer";
		data_excel[1][0]    ="dwayne";
	    data_excel[1][1]    ="wrestling";
		data_excel[2][0]    ="cena";
		data_excel[2][1]    ="acting";
		
		
		
	
		
		return data_excel;
		
    	
    	return data_obj;
	}

    
	*/
	
	

	
	@Test(dataProvider ="test_data")
	public void post_t01(String name,String job) {
		
		HashMap<String ,String>  map  = new HashMap();
		
		map.put("name", name);
		map.put("job", job);
		
		System.out.println(name+"----- "+job);
		
		JSONObject  req= new JSONObject(map);
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
		
	
		
		String response = given().accept(ContentType.JSON).body(req.toJSONString()).when().put("https://reqres.in/api/users").then().extract().asString();
		
		System.out.println("######"+response);
		
		
		
		
	}

}
