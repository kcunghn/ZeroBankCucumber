package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountActivity extends BasePage {


    @FindBy(id = "aa_accountId")
    public WebElement accountOptions;
    @FindBy(xpath = "//select")
    public WebElement accountText;

    @FindBy(xpath = "//div[@class='controls']")
    public WebElement accountButton;

    @FindBy(xpath = "//table//thead//tr//th")
    public List<WebElement> transactionTable;

    @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
    public WebElement findTransaction;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement description;
    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;
    @FindBy(id = "aa_toDate")
    public WebElement toDate;
    @FindBy(id = "aa_fromAmount")
    public WebElement fromAmount;
    @FindBy(id = "aa_toAmount")
    public WebElement toAmount;

    @FindBy(id = "aa_type")
    public WebElement type;
    @FindBy(xpath = "//button[contains(text(),'Find')]")
    public WebElement search;
    @FindBy(xpath = "(//tbody)[2]//tr//td[1]")
    public List<WebElement> dateTable;
    @FindBy(xpath = "(//tbody)[2]//tr//td[2]")
    public List<WebElement> descriptionTable;
    @FindBy(xpath = "(//tbody)[1]//tr//td[3]")
    public List<WebElement> depositTable;
    @FindBy(xpath = "(//tbody)[1]//tr//td[4]")
    public List<WebElement> withdrawalTable;




    public List<String> getAccountDrop() {
        Select select = new Select(accountOptions);
        List<WebElement> menuList = select.getOptions();
        List<String> menuListText = new ArrayList<>();
        for (WebElement element : menuList) {
            menuListText.add(element.getText());
        }

        return menuListText;
    }
    public String selectedDropDown(){
        Select select = new Select(Driver.get().findElement(By.xpath("//select")));
        WebElement option= select.getFirstSelectedOption();
        String selectedDropDownTest = option.getText();
        return selectedDropDownTest;
    }

    public void getType(String str){
        Select select = new Select(type);
        if(str.equalsIgnoreCase("Deposit")){
            select.selectByIndex(1);
        }else if(str.equalsIgnoreCase("Withdrawal")){
            select.selectByIndex(2);
        }

    }
public List<String> getTransactions(){
    List<String> elementsText = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//table//thead//tr//th")));
    return elementsText;
}


}