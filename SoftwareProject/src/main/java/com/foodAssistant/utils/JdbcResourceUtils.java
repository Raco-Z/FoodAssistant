package com.foodAssistant.utils;

import jdk.internal.util.xml.impl.Input;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JdbcResourceUtils {

    private static Properties jdbcConfig;
    //private static Map<String,String> jdbcConfig;

    static{
        try{
            jdbcConfig = new Properties();
            InputStream inputStream = JdbcResourceUtils.class.getClassLoader().getResourceAsStream("jdbcConfig.properties");
            jdbcConfig.load(inputStream);
            /*
            jdbcConfig = new HashMap<String, String>();
            Enumeration keys = props.keys();
            while(keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String value = props.getProperty(key);

                jdbcConfig.put(key,value);
            */
            } catch (Exception e){
            throw new ExceptionInInitializerError("wrong with init properties");
        }
    }

    public static Object getConfig(String key){
        return jdbcConfig.getProperty(key);
    }


}
