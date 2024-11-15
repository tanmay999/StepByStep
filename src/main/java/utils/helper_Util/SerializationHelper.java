package utils.helper_Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SerializationHelper {
    ObjectMapper objectMapper;

    public String  SerializePojoToJson(Object obj) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
      String jsonStr = objectMapper.writeValueAsString(obj);
        return  jsonStr;
    }


    public void SerializePojoToJsonFile(Object obj,String filepath) throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filepath+"target/"+obj.getClass().getName()+".json"),obj);
        System.out.println("json File has been created at path location "+filepath);
    }


}
