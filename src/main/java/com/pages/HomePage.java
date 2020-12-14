package com.pages;

import com.pages.base.BaseActivity;
import com.utils.Context;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HomePage extends BaseActivity {


    public HomePage(AppiumDriver driver) {
        super(driver);
    }
    WebDriverWait wait;

    @WithTimeout(time = 60, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id="com.google.android.calculator:id/op_add")
    private MobileElement addition;

    @WithTimeout(time = 60, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(accessibility="equals")
    private MobileElement equals;

    @WithTimeout(time = 60, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id="com.google.android.calculator:id/result_preview")
    private MobileElement resultText;


    public void clickOnElement(String element){
        driver.findElementById("com.google.android.calculator:id/digit_"+element).click();

    }

    public void takeAppinBackGround(){
        driver.runAppInBackground(Duration.ofSeconds(10));
    }

    public String equals_get_resuls(){

//        equals.click();
        String value=resultText.getText();
        System.out.println("result is "+value);
        return value;

    }
    public void performAddition(){
        addition.click();
    }
}
