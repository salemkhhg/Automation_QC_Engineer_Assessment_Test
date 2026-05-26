package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Add_User_page extends Base_Page{
    public Add_User_page (WebDriver driver) {
        super(driver);
    }
    public String user = "salem.sobhy15498";
    public WebElement headerAdduser = driver.findElement(By.cssSelector("div.orangehrm-card-container h6.oxd-text--h6"));
    public WebElement userRoleDropdown = driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-wrapper')])[1]"));
    public WebElement statusDropdown =  driver.findElement(By.xpath("(" + "//div[contains(@class,'oxd-select-wrapper')])[2]"));
    public WebElement employeeNameInput = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
    public WebElement usernameInput = driver.findElement(By.xpath( "//label[normalize-space()='Username']" + "/ancestor::div[contains(@class,'oxd-input-group')]//input"));
    public WebElement passwordInput =  driver.findElement(By.xpath("(//input[@type='password'])[1]"));
    public WebElement confirmPasswordInput = driver.findElement(By.xpath("(//input[@type='password'])[2]"));

    public WebElement saveButton = driver.findElement(By.cssSelector("button[type='submit']"));


    //Select select = new Select(userRoleDropdown);

    public boolean isLoaded() {
        try {
            return (headerAdduser).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void selectFromDropdown(WebElement dropdownWrapper, String optionText) {
        dropdownWrapper.click();
        WebElement option =driver.findElement(By.xpath("//div[@role='option']//span[normalize-space()='"
                + optionText + "']"));
        option.click();
    }

    public void fillName(String hint) {
        type(employeeNameInput, hint);

        // Wait for at least one suggestion to appear in the autocomplete dropdown
        By firstSuggestionLocator = By.xpath(
                "(//div[contains(@class,'oxd-autocomplete-dropdown')]//span)[1]");
        WebElement firstSuggestion = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstSuggestionLocator));
        firstSuggestion.click();
    }

    public void Write_Data(){
        usernameInput.sendKeys(user);
        passwordInput.sendKeys("aaSSdd261@");
        confirmPasswordInput.sendKeys("aaSSdd261@");
        selectFromDropdown(statusDropdown, "Enabled");
        selectFromDropdown(userRoleDropdown, "Admin");
        fillName("A");
        saveButton.click();
    }

    public boolean isSuccessMessageVisible() {
        try {
            WebElement toast = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[contains(@class,'oxd-toast--success')]")
                    )
            );
            return toast.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
