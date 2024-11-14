

package test_cases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class get_t01 extends  BaseTest {
	
	@Test
	public void get_test1(){
		
		given()
		.header("Content-Type","application/json")
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data[1].id", equalTo(8)).and()
		.log().all();
		
		String response = given().when().get("https://reqres.in/api/users?page=2").then().extract().toString();
		
		
		System.out.println("@@@@@@@@@@@@@@response string ->>"+response);
		
		
		JSONObject  res = new JSONObject();
		System.out.print("response string in JSON format _>>");
		System.out.println(res.toJSONString());
		
		
	}

}
