package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties properties;
    private static final String path = "C:.\\Configuration\\configuration.properties";

    public ReadConfig() throws IOException {
        properties = new Properties();
        FileInputStream ReadFile = new FileInputStream(path);
        properties.load(ReadFile);
    }

    public String getBrowser() {
        String value = properties.getProperty("browser");
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException(" Browser not configured in properties File");
        }
    }

    public String getBaseUrl(){
        String value = properties.getProperty("baseURL");
        if (value!= null){
            return value;
        }
        else {
            throw new RuntimeException(" Base URL not configured in properties File");
        }

    }


    public String getDefaultUsername(){
        String value = properties.getProperty("defaultUsername");
        if (value!= null){
            return value;
        }
        else{
            throw new RuntimeException("please provide default Username");
        }
    }

    public String getDefaultPassword(){
        String value = properties.getProperty("defaultPassword");
        if (value!= null){
            return value;
        }
        else{
            throw new RuntimeException("please provide default Password");
        }
    }

    public String getDefaultProductSearch(){
        String value = properties.getProperty("defaultProductSearch");
        if (value!= null){
            return value;
        }
        else{
            throw new RuntimeException("please provide default Search product");
        }
    }

}
