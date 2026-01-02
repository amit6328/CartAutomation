package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

    WebDriver driver;

    private By confirmationMessage = By.cssSelector(".hero-primary");

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
