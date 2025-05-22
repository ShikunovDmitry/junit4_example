package com.company.core;

import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    @Getter
    private static Properties properties;
    private static Properties localProperties;

    private Configuration() {
    }

    public static Properties getProperties() {
        if (properties == null) {
            initProperties();
        }
        return properties;
    }

    private static void initProperties() {
        properties = new Properties();
        localProperties = new Properties();

        try {
            properties.load(new FileInputStream("project.properties"));
            if(new File("local.properties").exists()){
                localProperties.load(new FileInputStream("local.properties"));
                properties.putAll(localProperties);
            }
            properties.putAll(System.getenv());
            properties.putAll(System.getProperties());
        } catch (IOException e) {
            System.out.println("Can't read properties");
        }
    }

    public static String getBaseUrl() {
        return getProperties().get("baseUrl").toString();
    }

    public static String getDownloadDirectory(){
        return properties.get("downloadDirectory").toString();
    }


    public static String getScreenShotFolder() {
        return properties.getProperty("screenshotFolder");
    }

    public static String getRemoteDriverUrl() {
        return properties.getProperty("remoteWebDriverUrl");
    }
}
