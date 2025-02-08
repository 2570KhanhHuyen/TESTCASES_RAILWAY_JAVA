package testcases.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class TC08 {
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
    public void TC08() {
        System.out.println("TC08 - User can't login with an account hasn't been activated");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.getLoginPage();
        String username = "huonglinh@gmail.com";
        String password = "12369872";
        String actualMsg = loginPage.login(username, password).getErrorMessage();
        String expectedErrorMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
}
