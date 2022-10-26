package utils;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver IEDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "D:\\Proyectos de Automatizacion\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By Locator) {
        return driver.findElement(Locator);
    }

    public List<WebElement> findElements(By Locator) {
        return driver.findElements(Locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By Locator) {
        return findElement(Locator).getText();
    }

    public String getAtributte(By Locator, String value) {
        return findElement(Locator).getAttribute(value);
    }

    public void click(By Locator) {
        driver.findElement(Locator).click();
    }

    public void write(By locator, String textToWrite){
        findElement(locator).clear();
        findElement(locator).sendKeys(textToWrite);
    }


    public void click(WebElement element) {
        element.click();
    }

    public Boolean isDisplayed(By Locator) {
        try {
            return driver.findElement(Locator).isDisplayed();

        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void Esperar(int segundos) {
        driver.manage().timeouts().setScriptTimeout(segundos, TimeUnit.SECONDS);
    }

    public void select(By locator, String text) {
        Select elegir = new Select(driver.findElement(locator));
        elegir.selectByValue(text);
    }

    public String alertacept() {
        Alert alert = driver.switchTo().alert();
        /*
         * System.out.println(alert.getText()); // Print Alert popup
         */
        String mensaje = alert.getText();
        alert.accept(); // Close Alert popup
        return mensaje;
    }

    public void btnacept(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
