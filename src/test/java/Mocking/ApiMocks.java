package Mocking;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class ApiMocks {

    public static void getDummyUser(){
        //http://localhost:8089/api/users
        stubFor(get(urlEqualTo("/api/users"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("ContentType","application/json")
                        .withBody("{\"name\" :\"tanmay\",\n" +
                                "                                      \"id\": 12}")));
    }


    public static void getDummyUserWithFile(){
        //http://localhost:8089/api/users
        stubFor(get(urlEqualTo("/api/users"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("ContentType","application/json")
                        .withBodyFile("user.json")));
    }


    public static void  deleteDummyUser(){
        //http://localhost:8089/api/users
        stubFor(delete(urlEqualTo("/api/user/1"))
                .willReturn(aResponse()
                        .withStatus(204)
                        .withHeader("server","NALsERVER")
                        .withStatusMessage("User deleted")));
    }

}
