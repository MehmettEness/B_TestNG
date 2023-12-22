package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class EnesAmazonPage {

    public EnesAmazonPage() {

        PageFactory.initElements(Driver.getDriver() , this);
    }
    @FindBy (id="twotabsearchtextbox")
    public WebElement searchBox;

}
