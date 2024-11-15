package test_cases;

import RestClient.Crud_Http_Call;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.helper_Util.ConfigManager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestCase1 extends  BaseTest{

    @Test
    public void test1() throws IOException {

       /* String path=System.getProperty("user.dir")+ File.separator+"src\\test\\resources\\GlobalProperties.properties";
        String baseUriPet = ConfigManager.get("BASE_URI_PET");
        String basePathPet = ConfigManager.get("PET_BY_ID");*/
        Map<String,String> tokenParam = new HashMap<String, String>();
        tokenParam.put("id","9999");

      String   baseUriPet="https://petstore.swagger.io";
      String   basePathPet="/v2/pet/99";

      Response response = Crud_Http_Call.doGet("GET",baseUriPet,"JSON",basePathPet,null,null,true);
        response.getBody().prettyPrint();
    }


}
