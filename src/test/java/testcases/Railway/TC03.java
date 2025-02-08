package testcases.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class TC03{
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
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.getLoginPage();
        String actualErrorMsg = loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD).getErrorMessage();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
}

