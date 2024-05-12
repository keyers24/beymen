package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.searchPage;
import java.time.Duration;
import static util.initializeDrivers.getDriver;

public class searchPageTest extends baseTest{
    WebDriver driver;
    WebDriverWait wait;
    searchPage searchPage;
    baseTest baseTest;
    Logger log;

    public searchPageTest() {
        this.baseTest=new baseTest();
        this.driver=getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.searchPage=new searchPage(driver,wait);
        this.log= LogManager.getLogger(searchPageTest.class);
    }
    @Test
    public void searchShortsProduct(){
        baseTest.Early();

        baseTest.senKeyElement(searchPage.searchInput,readExcelData(0,0,0));
        baseTest.click(searchPage.clearText);

    }
    @Test
    public void searchShirtProduct(){
        baseTest.Early();

        baseTest.senKeyElement(searchPage.searchInput,readExcelData(0,0,1));
        baseTest.pressEnter(searchPage.searchInput);
    }
    @Test
    public void basketOperations(){
        searchShirtProduct();

        String firstPrice= searchPage.firstPrice.getText();
        baseTest.click(searchPage.shirtProdcut);

        Assertions.assertEquals(firstPrice,searchPage.basketPrice.getText());
        baseTest.click(searchPage.size);
        baseTest.click(searchPage.addBasket);
        baseTest.click(searchPage.basketBtn);
        baseTest.sleep();
        baseTest.writeTxt(searchPage.basketProduct,searchPage.salePrice);
        baseTest.click(searchPage.productQuantity);
        baseTest.click(searchPage.twoPieces);
        baseTest.sleep();
        baseTest.click(searchPage.deleteCart);
        baseTest.checkElement(searchPage.checkDeleteCart);
        log.info("Test Finished");
    }



}
