package com.pages.base;

import com.utils.Context;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActivity {
    protected AppiumDriver driver;
    private WebDriverWait wait;
    Context context;


    public BaseActivity(AppiumDriver driver) {
        this.driver=driver;
        this.wait =  new WebDriverWait(driver, 120);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
}

