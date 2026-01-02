package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.AbstractComponent;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    private By userEmail = By.id("userEmail");
    private By password = By.id("userPassword");
    private By loginBtn = By.id("login");

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ProductCatalogue loginApplication(String email, String pwd) {
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();
        return new ProductCatalogue(driver);
    }
}
