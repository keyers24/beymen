package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage extends basePage{

    public homePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @FindBy(css = "img[alt='Beymen']")
    public WebElement checkLogo;
}
