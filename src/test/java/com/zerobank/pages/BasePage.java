package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//li")
    public List<WebElement> menuOptions;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//li[1]")
    public WebElement accountSummary;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//li[2]")
    public WebElement accountActivity;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//li[3]")
    public WebElement transferFunds;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//li[4]")
    public WebElement payBills;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//li[5]")
    public WebElement myMoneyMap;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//li[6]")
    public WebElement onlineStatement;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToModule(String menu) {

        switch (menu.toLowerCase()) {
            case "account summary":
                accountSummary.click();
                break;
            case "account activity":
                accountActivity.click();
                break;
            case "transfer funds":
                transferFunds.click();
                break;
            case "pay bills":
                payBills.click();
                break;
            case "my money map":
                myMoneyMap.click();
                break;
            case "online statement":
                onlineStatement.click();
                break;
        }


    }
}
