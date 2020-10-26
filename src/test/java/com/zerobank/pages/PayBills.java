package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PayBills {
    public PayBills(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//select[@id='sp_payee']")
    public WebElement payee;
    @FindBy(id = "sp_account")
    public WebElement account;
    @FindBy(id = "sp_amount")
    public WebElement amount;
    @FindBy(id = "sp_date")
    public WebElement date;
    @FindBy(id = "sp_description")
    public WebElement description;
    @FindBy(id = "pay_saved_payees")
    public WebElement submitBtn;
    @FindBy(xpath = "//span[contains(text(),'The payment was successfully submitted.')]")
    public WebElement confMessage;

public void setPayee(){
    Select select = new Select(payee);
    select.selectByIndex(2);
}
public void setAccount(){
    Select select = new Select(account);
    select.selectByIndex(3);
}
}
