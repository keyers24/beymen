package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchPage extends basePage {
    public searchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @FindBy(css = ".o-header__search--input")
    public WebElement searchInput;
    @FindBy(css = ".o-header__search--close")
    public WebElement clearText;
    @FindBy(xpath = "//span[normalize-space()='Comfort Fit Indigo Oxford Gömlek']")
    public WebElement shirtProdcut;
    @FindBy(xpath = "//span[contains(text(),'2.699 TL')]")
    public WebElement firstPrice;
    @FindBy(css = "div[class='m-variation'] span:nth-child(1)")
    public WebElement size;
    @FindBy(id = "priceNew")
    public WebElement basketPrice;
    @FindBy(css = ".m-basket__productInfoName")
    public WebElement basketProduct;
    @FindBy(css = ".priceBox__salePrice")
    public WebElement salePrice;
    @FindBy(id = "addBasket")
    public WebElement addBasket;
    @FindBy(css = "button[class='m-notification__button btn']")
    public WebElement basketBtn;
    @FindBy(id = "removeCartItemBtn0-key-0")
    public WebElement deleteCart;
    @FindBy(css = "div[id='emtyCart'] strong[class='m-empty__messageTitle']")
    public WebElement checkDeleteCart;
    @FindBy(id = "quantitySelect0-key-0")
    public WebElement productQuantity;
    @FindBy(css = "option[value='2']")
    public WebElement twoPieces;
}
