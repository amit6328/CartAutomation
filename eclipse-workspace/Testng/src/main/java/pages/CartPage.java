package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.AbstractComponent;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    private By cartProducts = By.cssSelector(".cartSection h3");
    private By checkoutButton = By.cssSelector(".totalRow button");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean verifyProductDisplay(String productName) {
        List<WebElement> products = driver.findElements(cartProducts);
        return products.stream()
                .anyMatch(product ->
                        product.getText().equalsIgnoreCase(productName));
    }

    public CheckoutPage goToCheckout() {
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }
}
