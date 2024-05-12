package tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage;
import java.io.*;
import static util.initializeDrivers.getDriver;
import static util.initializeDrivers.initializeDriver;
import java.time.Duration;

public class baseTest {

    static WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    basePage basePage;

    public baseTest() {
        this.driver = getDriver();
        this.actions = new Actions(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        basePage=new basePage(driver,wait);
    }
    public void Early(){
        click(basePage.oneTrustBtn);
        click(basePage.genderPopup);
    }
    public  boolean isDisplayed(WebElement element){
        try
        {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public  void senKeyElement(WebElement key, String text){
        WebElement element=checkElement(key);
        element.sendKeys(text);
    }

    public WebElement checkElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void pressEnter(WebElement Element){
        WebElement element=checkElement(Element);
        element.sendKeys(Keys.ENTER);
    }
    public void clearText(WebElement Element){
        WebElement element=checkElement(Element);
        element.sendKeys();
    }

    public  void click(WebElement Element){
        WebElement element=checkElement(Element);
        element.click();
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void hover(WebElement element){
        new Actions(driver).moveToElement(element).build().perform();
    }
    public void getWindowHandle(){
        String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public  void  sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String readExcelData(int pageNumber,int row,int column) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File("src/main/resources/Kitap.xlsx"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            // İlk sayfa
            Sheet sheet = workbook.getSheetAt(pageNumber);

            // İlk satır
            Row headerRow = sheet.getRow(row);

            // İlk sütunun adı
            String columnName = headerRow.getCell(column).getStringCellValue();

        return columnName;
    }
    public void writeTxt(WebElement Element1,WebElement Element2){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/spans_texts.txt"))) {
            writer.write("Product Name : " +checkElement(Element1).getText());
            writer.newLine();
            writer.write("Price: " + checkElement(Element2).getText());
            System.out.println("Span metinleri başarıyla dosyaya yazıldı.");
        } catch (IOException e) {
            System.err.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }

    @BeforeClass
    public static void before(){
        driver=initializeDriver();

    }
    @AfterClass
    public static void tearDown(){driver.quit();}
}
