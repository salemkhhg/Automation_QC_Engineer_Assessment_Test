package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Admin_Page extends Base_Page{
    public Admin_Page(WebDriver driver) {
        super(driver);
    }


    public WebElement headerAdminPage = driver.findElement(By.cssSelector("h6.oxd-topbar-header-breadcrumb-module"));
    public WebElement labelcounter = driver.findElement(By.xpath("//span[contains(@class,'oxd-text--span') and contains(.,'Record')]"));
    public WebElement Addbutton = driver.findElement(By.xpath("//button[normalize-space()='Add']"));


    public int getRecordsCount() {
        String text = getText(labelcounter);
        // Strip every non-digit character: "(25) Records Found" → "25"
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }
    public boolean isLoaded() {
        try {
            return (headerAdminPage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
     public void Add_button_click(){
         Addbutton.click();
     }


}
