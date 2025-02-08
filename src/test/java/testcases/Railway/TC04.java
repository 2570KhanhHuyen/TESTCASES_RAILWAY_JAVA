package testcases.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;

public class TC04 {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test
    public void TC04() {
        System.out.println("TC04 -Login page displays when un-logged User clicks on Book ticket tab");
        HomePage homePage = new HomePage();
        homePage.open();
        String actualMessage = homePage.getBookTicketPage().getTitleLoginPage();
        String expectedMsg = "Login page";
        Assert.assertEquals(actualMessage, expectedMsg, "Login page displays instead of Book ticket page");
    }
}
