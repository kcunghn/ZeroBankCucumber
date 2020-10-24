package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends BasePage {


    @FindBy(id = "aa_accountId")
    public WebElement accountOptions;

    @FindBy(xpath = "//div[@class='controls']")
    public WebElement accountButton;

    public List<String> getAccountDrop() {
        Select select = new Select(accountOptions);
        List<WebElement> menuList = select.getOptions();
        List<String> menuListText = new ArrayList<>();
        for (WebElement element : menuList) {
            menuListText.add(element.getText());
        }

        return menuListText;
    }
}