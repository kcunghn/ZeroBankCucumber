package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PayBills extends BasePage {
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
    @FindBy(xpath = "//a[contains(text(),'Add New Payee')]")
    public WebElement addNewPayee;
    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement payeeName;
    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;
    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;
    @FindBy(xpath = "//input[@id='np_new_payee_details']")
    public WebElement payeeDetails;
    @FindBy(id = "add_new_payee")
    public WebElement submitPayee;
    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement alert;
    @FindBy(xpath = "//a[contains(text(),'Purchase Foreign Currency')]")
    public WebElement purchaseForeignCurrency;
    @FindBy(id = "pc_currency")
    public WebElement currency;
    @FindBy(id = "pc_amount")
    public WebElement getAmount;
    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateBtn;
    @FindBy(id = "pc_inDollars_true")
    public WebElement dollarRadio;
    @FindBy(id = "pc_inDollars_false")
    public WebElement selCurrencyRadio;



public void setPayee(){
    Select select = new Select(payee);
    select.selectByIndex(2);
}
public void setAccount(){
    Select select = new Select(account);
    select.selectByIndex(3);
}
public List<String> getCurrency(){
    Select select = new Select(currency);
    List<WebElement> menuList = select.getOptions();
    List<String> menuListText = new ArrayList<>();
    for (WebElement element : menuList) {
        menuListText.add(element.getText());
    }

    return menuListText;

}
}
