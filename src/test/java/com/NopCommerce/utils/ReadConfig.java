package com.NopCommerce.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    private Properties pro;

    public ReadConfig() {
        File src = new File("./src/main/java/com/NopCommerce/config/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            this.pro = new Properties();
            this.pro.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public String getUrl() {
        return pro.getProperty("baseUrl");
    }

    public String get_useremail() {
        return pro.getProperty("useremail");
    }

    public String get_password() {
        return pro.getProperty("password");
    }

    public String get_chromepath() {
        return pro.getProperty("chromepath");
    }

    public String get_firefoxpath() {
        return pro.getProperty("firefoxpath");
    }
}
