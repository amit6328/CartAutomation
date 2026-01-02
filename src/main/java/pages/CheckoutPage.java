package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;

    private By countryField = By.cssSelector("[placeholder='Select Country']");
    private By results = By.cssSelector(".ta-results");
    private By submitOrder = By.cssSelector(".action__submit");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectCountry(String countryName) {
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(countryField), countryName)
               .build()
               .perform();
        waitForElementToAppear(results);
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
    }

    public ConfirmationPage submitOrder() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement submitBtn = driver.findElement(submitOrder);

        // Scroll into view
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", submitBtn);

        // Wait until no overlay is blocking
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));

        // JS click to bypass interception
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", submitBtn);

        return new ConfirmationPage(driver);
    }
}
