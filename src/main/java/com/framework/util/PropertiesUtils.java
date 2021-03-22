package com.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesUtils {
	
	String file;
	
    public PropertiesUtils(String file) {
        this.file = file;
        
       
    }

    public String getProperty(String name){
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(name);
    }
    

}
