package com.hooks;

import com.utils.AppiumHelper;
import com.utils.Context;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    AppiumHelper appiumHelper;
    Context context;

    public Hooks(Context context){
        this.context=context;
    }

    @Before(order = 1)
    public void startAppiumServer(){

        appiumHelper = new AppiumHelper(context);
        appiumHelper.startAppiumServer();


        System.out.println("Start appium server ");
    }

    @Before(order = 2)
    public void startDriver(){
        appiumHelper.getDriver();
        context.initPages(context.getDriver());
        System.out.println("Start appium driver ");
    }

    @After(order = 1)
    public void killDiver(){
        context.getDriver().quit();
        context.getService().stop();
        System.out.println("kill appium driver ");

    }


}
