package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class User_Page extends Base_Page{
    public User_Page(WebDriver driver) {
        super(driver);
    }

    public WebElement username = driver.findElement(By.xpath("//label[normalize-space()='Username']/following::input[1]"));
    public WebElement search_button = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
    public WebElement delete_button = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//button)[1]"));
    public WebElement getConfirmDeleteButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Yes, Delete']")
                )
        );
    }



    public void Delete_user() {
        username .sendKeys("salem.sobhy15498");
        search_button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        delete_button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@class='oxd-table-card']//button)[1]")
        ));
        delete_button.click();
        getConfirmDeleteButton().click();
    }
}
