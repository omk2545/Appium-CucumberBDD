package com.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MobileSelector;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Rough {

    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement>  driver;
    public static Properties prop;
    public static void startServer()
    {
            service=AppiumDriverLocalService.buildDefaultService();
            service.start();
    }




    public static void main(String[] args) throws IOException {

        startServer();

        String  packageName = null;



        // TODO Auto-generated method stub
//        File appDir = new File("src");
//     File app = new File(appDir, (String) prop.get(appName));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String device= prop.getProperty("deviceName");
        String activityName = prop.getProperty("appActivity");
        String appPackage = prop.getProperty("appPackage");
        if(device.contains("emulator"))
        {
//            startEmulator();
        }
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//     capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", activityName);
//			com.makemytrip/com.mmt.travel.app.home.ui.SplashActivit
//     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



      
    }


}
