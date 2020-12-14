package com.utils;

import com.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Context {
    private AppiumDriver driver;
    private Properties properties;
    private AppiumDriverLocalService service;
    private AppiumHelper appiumHelper ;



    HomePage homePage;


    public HomePage getHomePage() {
        return homePage;
    }

    public AppiumDriverLocalService getService() {

        return service;
    }

    public void setService(AppiumDriverLocalService service) {
        this.service = service;
    }



    public Properties getProperties() {

        if (properties == null) {
            FileInputStream fis= null;
            try {
                fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            properties=new Properties();
            try {
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return properties;
    }




    public AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }


    public void initPages(AppiumDriver driver){
         homePage = new HomePage(driver);
//         PageFactory.initElements(new AppiumFieldDecorator(driver), HomePage.class);


    }
}
