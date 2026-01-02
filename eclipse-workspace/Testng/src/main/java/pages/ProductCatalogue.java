package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

    WebDriver driver;

    private By productsBy = By.cssSelector(".mb-3");
    private By addToCartBtn = By.cssSelector(".mb-3:nth-of-type(1) .card-body button:last-of-type");
    private By toastMessage = By.cssSelector("#toast-container");
    private By loadingSpinner = By.cssSelector(".ng-animating");
    private By cartHeader = By.cssSelector("[routerlink*='cart']");

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<WebElement> getProductList() {
        waitForElementToAppear(productsBy);
        return driver.findElements(productsBy);
    }

    public WebElement getProductByName(String productName) {
        return getProductList().stream()
                .filter(product ->
                        product.findElement(By.cssSelector("b"))
                               .getText().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }

    public void addProductToCart(String productName) {
        WebElement product = getProductByName(productName);
        product.findElement(addToCartBtn).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(driver.findElement(loadingSpinner));
    }

    public CartPage goToCartPage() {
        driver.findElement(cartHeader).click();
        return new CartPage(driver);
    }
}
