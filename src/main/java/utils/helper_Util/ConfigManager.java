package utils.helper_Util;

import java.io.*;
import java.util.Properties;

public class ConfigManager {

   Properties properties;

    public  ConfigManager() throws IOException {
        properties=new Properties();
        FileInputStream fileInputStream    = new FileInputStream(System.getProperty("user.dir")+File.separator+"src\\test\\resources\\GlobalProperties.properties");
        properties.load(fileInputStream);
    }


        public   String get(String key){
            return properties.getProperty(key);
        }

        public  void set(String key,String value){
            properties.setProperty(key,value);
        }


}
