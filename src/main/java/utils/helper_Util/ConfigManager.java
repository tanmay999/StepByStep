package utils.helper_Util;

import java.io.*;
import java.util.Properties;

public class ConfigManager {

   private static Properties properties=new Properties();

    public  ConfigManager() throws IOException {
        FileInputStream fileInputStream    = new FileInputStream(System.getProperty("user.dir")+File.separator+"src\\test\\resources\\GlobalProperties.properties");
        properties.load(fileInputStream);
    }


        public static  String get(String key){
            return properties.getProperty(key);
        }

        public static void set(String key,String value){
            properties.setProperty(key,value);
        }


}
