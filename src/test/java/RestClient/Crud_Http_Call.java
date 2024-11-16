package RestClient;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;
import java.util.Map;


public class Crud_Http_Call {


    public static  Response doGet(String httpMethod,String baseUri,String contentType,String basePath,
                                  Map<String,String> tokenMap,Map<String,String> queryParam,String params,boolean log){
        if(setBaseURI(baseUri)){
            RequestSpecification request = createRequestSpec(contentType,tokenMap,log);
            applyPrams(request,queryParam,params);

            Response response = executeHttpMethod(httpMethod,request,basePath);
            return  response;
        }

        return null;
    }


    public static <T> Response doPost(T body,String httpMethod,String baseUri,String contentType,String endpoint,Map<String,String> tokenParam,
                         Map<String,String> queryParam,String params,boolean log ){
        ResponseSpecification responseSpec = null;
        Response response =null;
        if(setBaseURI(baseUri)){
            RequestSpecification request = createRequestSpec(contentType,tokenParam,log);
            applyPrams(request,queryParam,params);

            response =    request.body(body).post(endpoint).then().extract().response();
            response.prettyPrint();

        }

        return  response;

    }



 /*   public RequestSpecification setUpRequestHeader(RequestSpecification, String baseUrl, String contentType, String authkey) {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(baseUrl);
        requestSpecification.contentType(contentType);
        try {

            if ("BEARER_TOKEN".equals(authkey)) {
                requestSpecification.header("Authorization", "Bearer " + ConfigManager.get("bearerToken"));
            } else if ("NO_AUTH".equals(authkey)) {
                System.out.println("no auth required");
            } else {
                System.out.println("this auth does not supported");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return requestSpecification;

    }*/


    private  static void applyPrams(RequestSpecification requestSpecification, Map<String, String> queryParams, String pathParams) {
        if (queryParams != null) {
            requestSpecification.queryParams(queryParams);
        }
        if (pathParams != null)
            requestSpecification.pathParam("id",pathParams);
    }

    private static boolean setBaseURI(String baseUri) {
        if (baseUri == null) {
            System.out.println("base URI is null");
            return false;
        }
        try {
            RestAssured.baseURI = baseUri;
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }

    }


    private static RequestSpecification createRequestSpec(String contentType, Map<String, String> tokenMap,
                                                          boolean log) {

        RequestSpecification requestSpecification = null;
        if (log) {
            requestSpecification = RestAssured.given().log().all();
        }

        if (tokenMap!=null && tokenMap.size() > 0) {
            requestSpecification.headers(tokenMap);
        }

        if (contentType != null) {

            if (contentType.equalsIgnoreCase("JSON")) {
                requestSpecification.contentType(ContentType.JSON);
            } else if (contentType.equalsIgnoreCase("XML"))
                requestSpecification.contentType(ContentType.XML);
        } else if (contentType.equalsIgnoreCase("TEXT")) {
            requestSpecification.contentType(ContentType.TEXT);
        } else if (contentType.equalsIgnoreCase("MULTIPART")) {
            requestSpecification.multiPart(new File("src/test/resources/abc.png"));
        }
        return requestSpecification;
    }


    private static Response executeHttpMethod(String httpMethodType, RequestSpecification requestSpecification, String basePath) {

        Response response = null;

        if (httpMethodType.equalsIgnoreCase("GET")) {
            response = requestSpecification.get(basePath);
        } else if (httpMethodType.equalsIgnoreCase("POST")) {
            response = requestSpecification.post(basePath);
        } else if (httpMethodType.equalsIgnoreCase("DELETE")) {
            response = requestSpecification.delete(basePath);
        } else if (httpMethodType.equalsIgnoreCase("PATCH")) {
            response = requestSpecification.patch(basePath);
        } else if (httpMethodType.equalsIgnoreCase("put")) {
            response = requestSpecification.put(basePath);
        } else {
            System.out.println("Invalid httpMethod type ");
        }

        return response;

    }

}
