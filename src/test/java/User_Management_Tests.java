import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class User_Management_Tests {
    WebDriver driver;
    int initialCount = 0;

    @BeforeTest
    public void Setup(){
        driver = new ChromeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(testName = "Navigate and login", priority = 0)
    public void Login_Page(){
        Login_page login_page = new Login_page(driver);

        Assert.assertTrue(login_page.isLoaded(),
                "Dashboard should be visible after successful login");

        login_page.loginsubmit();
    }

    @Test(testName = "navigate to dashboard", priority = 1)
    public void Dashboard_Page(){
        Dashboard_Page dashboardPage = new Dashboard_Page(driver);

        Assert.assertTrue(dashboardPage.isLoaded(),
                "Dashboard should be visible after successful login");

        dashboardPage.admin_click();
    }

    @Test(testName = "navigate to Admin_page", priority = 2)
    public void Admin_Page(){
        Admin_Page adminPage = new Admin_Page(driver);

        Assert.assertTrue(adminPage.isLoaded(),
                "Dashboard should be visible after successful login");

        initialCount = adminPage.getRecordsCount();
        System.out.printf("▶  Initial record count : %d%n", initialCount);

        adminPage.Add_button_click();
    }

    @Test(testName = "navigate to Add_User_page", priority = 3)
    public void Add_User_pag(){

        Add_User_page addUserPage = new Add_User_page (driver);

       Assert.assertTrue(addUserPage.isLoaded(),
                "Dashboard should be visible after successful login");

        addUserPage.Write_Data();
        Assert.assertTrue(addUserPage.isSuccessMessageVisible(),
                "success message should be be visible after successful login");
    }

    @Test(testName = "Verify the number of users increased by 1", priority = 4)
    public void Admin_page_increased(){

        Admin_Page adminPage = new Admin_Page(driver);

        int afterAddCount = adminPage.getRecordsCount();
        System.out.printf("▶  After-add user : %d%n", afterAddCount);

        Assert.assertEquals(afterAddCount, initialCount + 1,
                String.format(
                        "Expected record count to be %d after adding a user, but was %d",
                        initialCount + 1, afterAddCount));
    }

    @Test(testName = "Delete User", priority = 5)
    public void user_Delete(){

        User_Page userPage = new User_Page(driver);
        userPage.Delete_user();
        WebElement successMsg = userPage.getSuccessMessage();
        Assert.assertTrue(successMsg.isDisplayed());
        Assert.assertEquals(successMsg.getText(), "Successfully Deleted");
        userPage.admin_click();
    }

    @Test(testName = "Verify the number of users decreased by 1", priority = 6)
    public void decreased(){
        Admin_Page adminPage = new Admin_Page(driver);
        int afterAddCount = adminPage.getRecordsCount();
        System.out.printf("▶  After-delete User : %d%n", afterAddCount);

        Assert.assertEquals(afterAddCount, initialCount ,
                String.format(
                        "Expected record count to be %d after adding a user, but was %d",
                        initialCount , afterAddCount));
    }

}
