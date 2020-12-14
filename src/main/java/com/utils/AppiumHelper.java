package com.utils;

import com.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppiumHelper {
    AppiumDriver<MobileElement> driver;
    Context context;
    Properties prop;
    AppiumDriverLocalService service;



    public AppiumHelper(Context context) {
        this.context=context;
        prop = this.context.getProperties();
    }

    public AppiumDriver getDriver(){
        return getAndroidDriver();

    }


    private AppiumDriver getIOSDriver(){
        return driver;
    }

    private AppiumDriver getAndroidDriver(){

        if (driver == null) {

        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String device= prop.getProperty("deviceName");
        String activityName = prop.getProperty("appActivity");
        String appPackage = prop.getProperty("appPackage");

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
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setDriver(driver);
        return driver;
    }


    public void startAppiumServer(){
       service = AppiumDriverLocalService.buildDefaultService();
       context.setService(service);
       context.getService().start();
    }
    public void initPages(){




    }
}
