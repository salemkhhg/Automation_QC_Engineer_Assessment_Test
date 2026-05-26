package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard_Page extends Base_Page{
    public Dashboard_Page(WebDriver driver){
        super(driver);
    }
    //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    public WebElement AdminMenuItem = driver.findElement(By.xpath("//span[text()='Admin']"));
    public WebElement headerDashPage = driver.findElement(By.cssSelector(".oxd-topbar-header-breadcrumb"));
    public boolean isLoaded() {
        try {
            return (headerDashPage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void admin_click(){
        AdminMenuItem.click();
    }


}
