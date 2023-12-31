package cydeo.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyToGet {
    private static Properties properties;
    static{
        try{
            properties = new Properties();
            FileInputStream file = new FileInputStream("config.properties");
            properties.load(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String is(String key){
        return properties.getProperty(key);
    }
}
