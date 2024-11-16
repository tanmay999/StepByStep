package Mocking;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class WireMockSetup {

    private static WireMockServer server;

     @BeforeTest
    public static void createWireMockServer(){
        server = new WireMockServer(8089);
        WireMock.configureFor("localHost",8089);
        server.start();
    }

    @AfterTest
    public static  void stopWireMockServer(){
        server.stop();

    }
}
