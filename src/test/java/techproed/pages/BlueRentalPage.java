package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {
    public BlueRentalPage() {
        PageFactory.initElements(Driver.getDriver() , this);

    }
    @FindBy (xpath = "//li//a[@role='button']")
    public WebElement loginButton;

    @FindBy (id = "formBasicEmail")
    public WebElement email;

    @FindBy (id = "formBasicPassword")
    public WebElement password;

    @FindBy (id = "dropdown-basic-button")
    public WebElement loginVerify;

    @FindBy (xpath = "//*[contains( text() , 'User with email' )]")
    public WebElement negatifLoginVerify;

    @FindBy (xpath = "//*[text()='Profile']")
    public WebElement profile;

    @FindBy (xpath = "//em")
    public WebElement profileEmail;

    @FindBy (xpath = "//a[.='Logout']")
    public WebElement logoutButton;

    @FindBy (xpath = "//*[.='OK']")
    public WebElement okButton;

    @FindBy (xpath = "//*[text()='Bad credentials']")
    public WebElement bad_credentials;

    @FindBy (xpath = "//*[text()='email must be a valid email']")
    public WebElement emailErrorMessage;

    @FindBy (xpath = "//select[@name='car']")
    public WebElement selectCar;

    @FindBy (xpath = "//input[@name='pickUpLocation']")
    public WebElement pickUpLocation;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement reservationButton;

    @FindBy (xpath = "//*[text()='Please first login']")
    public WebElement pleaseFirstLogin ;


}
