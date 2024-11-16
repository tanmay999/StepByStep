package test_cases;

import RestClient.Crud_Http_Call;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payload.CreatePostRequestBody;
import pojo.CreateProjectPojoRequest.CreatePetRoot;
import utils.helper_Util.ConfigManager;

import java.io.IOException;


public class TestCase1 extends  BaseTest{


    ConfigManager configManager ;


    @Test
    public void testDoGetFlow() throws IOException {
        configManager = new ConfigManager();

        String baseUriPet = configManager.get("BASE_URI_PET");
        String basePath= configManager.get("PET_BY_ID").toString();
        String petId =configManager.get("PET_ID");
        String basePathPet= "/v2/pet/"+petId;

      Response response = Crud_Http_Call.doGet("GET",baseUriPet,"JSON",basePathPet,null,null,null,true);
        response.getBody().prettyPrint();
    }


   @Test
    public void testDoPostFlow() throws IOException {

        configManager = new ConfigManager();
        String baseUriPet = configManager.get("BASE_URI_PET");
        String basePath= configManager.get("PET_POST_BY_ID");
        CreatePostRequestBody createPostRequestBody = new CreatePostRequestBody();
        CreatePetRoot createPetRootBody =createPostRequestBody.postPetRequestBody();
        Crud_Http_Call.doPost(createPetRootBody,"POST",baseUriPet,"JSON",basePath,null,null,null,true);

    }




}
