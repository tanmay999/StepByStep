package utils.helper_Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.io.IOException;

public class SerializationHelper {
    ObjectMapper objectMapper;
    public  SerializationHelper(){
        objectMapper = new ObjectMapper();
    }


    public String  SerializePojoToJson(Object obj) throws JsonProcessingException {
      String jsonStr = objectMapper.writeValueAsString(obj);
        return  jsonStr;
    }


    public void SerializePojoToJsonFile(Object obj,String filepath) throws IOException {
        objectMapper.writeValue(new File(filepath+obj.getClass().getName()+".json"),obj);
        System.out.println("json File has been created at path location "+filepath);
    }


    public Object DeSerializeJsonToPojo(String jsonStr,Object obj) throws JsonProcessingException {
        Object obj1=objectMapper.readValue(jsonStr,obj.getClass());
        return obj1;
    }

    public  Object DeserializeJsonFileToPojo(String filepath) throws IOException {
        Object objres=objectMapper.readValue(new File(filepath),Object.class);
        return objres;
    }


}
