package test_cases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {


     //BASE URL
    protected final static String BASE_URL_PET="https://petstore.swagger.io";

    //ENDPOINT

    protected final static String PET_BY_ID="/v2/pet/";

   @BeforeSuite
    public void SetUpReport(){

    }

    @BeforeTest
    public void Setup(){


    }



   @AfterTest
    public void stopMockServer(){


    }




}
