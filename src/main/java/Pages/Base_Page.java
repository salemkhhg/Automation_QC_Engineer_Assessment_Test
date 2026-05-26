package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class Base_Page {
    protected WebDriver driver;
    public WebDriverWait wait;


    public Base_Page(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected String getText(WebElement element) {
        return (element).getText().trim();
    }


    // ↑ initialized ONCE here — every child class gets it via super(driver)


    public void waitForVisibility(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void type(WebElement element, String text) {
    waitForVisibility(element);
    element.clear();
    element.sendKeys(text);
    }
}




