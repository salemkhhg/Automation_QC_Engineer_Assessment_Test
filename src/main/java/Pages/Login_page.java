package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_page extends Base_Page {
    public Login_page(WebDriver driver) {
        super(driver);
    }

    public WebElement user_name = driver.findElement(By.name("username"));
    public WebElement password = driver.findElement(By.name("password"));
    public WebElement login_button = driver.findElement(By.cssSelector("button[type='submit']"));
    public WebElement headerLoginPage = driver.findElement(By.cssSelector("h5.orangehrm-login-title"));

    public void loginsubmit () {
        user_name.sendKeys("Admin");
        password.sendKeys("admin123");
        login_button.click();
    }
    public boolean isLoaded() {
        try {
            return (headerLoginPage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
