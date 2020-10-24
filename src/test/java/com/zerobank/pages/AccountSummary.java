package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummary extends BasePage{
    public AccountSummary(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//div[@class='offset2 span8']//h2")
    public List<WebElement> accountTypes;
    @FindBy(xpath = "(//tr)[6]//th")
    public List<WebElement> accountTable;


}
