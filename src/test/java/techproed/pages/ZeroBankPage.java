package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class ZeroBankPage {
    public ZeroBankPage() {
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy (xpath = "//button[@id='signin_button']")
    public WebElement signInButton;

    @FindBy (xpath = "//input[@id='user_login']")
    public WebElement userName;

    @FindBy (xpath = "//input[@id='user_password']")
    public WebElement passWord;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement signInSubmit;

    @FindBy (xpath = "//*[strong='Online Banking']")
    public WebElement onlineBanking;

    @FindBy (xpath = "//span[@id='pay_bills_link']")
    public WebElement payPall;

    @FindBy (xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement PFC;

    @FindBy (xpath = "//select[@id='pc_currency']")
    public WebElement currency;



}
