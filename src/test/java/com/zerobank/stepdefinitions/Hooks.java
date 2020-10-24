package com.zerobank.stepdefinitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before

    public void setUp(){

        System.out.println("this is coming from BEFORE");
    }
    @After

    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte [] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        BrowserUtils.waitFor(2);
        Driver.closeDriver();
    }


    @Before("@db")

    public void setDb(){
        System.out.println("connecting database");
    }
    @After("@db")

    public void closDb(){
        System.out.println("disconnecting database");
    }
}
