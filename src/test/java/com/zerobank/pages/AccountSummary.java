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
    @FindBy(xpath = "(//a[text()='Savings'])[1]")
    public WebElement savings;
    @FindBy(xpath = "//a[contains(text(),'Brokerage')]")
    public WebElement brokerage;
    @FindBy(xpath = "//a[contains(text(),'Checking')]")
    public WebElement checking;
    @FindBy(xpath = "//a[contains(text(),'Credit Card')]")
    public WebElement creditCard;
    @FindBy(xpath = "//a[contains(text(),'Loan')]")
    public WebElement loan;

public void getAccountSummary(String summaryType){
    if(summaryType.equalsIgnoreCase("savings")){
        savings.click();
    }else if(summaryType.equalsIgnoreCase("brokerage")){
        brokerage.click();
    }else if(summaryType.equalsIgnoreCase("checking")){
        checking.click();
    }else if(summaryType.equalsIgnoreCase("creditCard")){
        creditCard.click();
    }else if(summaryType.equalsIgnoreCase("loan")){
        loan.click();
    }

}

}
