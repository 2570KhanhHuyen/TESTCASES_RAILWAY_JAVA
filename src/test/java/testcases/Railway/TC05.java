package testcases.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class TC05 {
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
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.getLoginPage();
        String username = Constant.USERNAME;
        String wrongPassword =  Constant.INVALID_PASSWORD;
        for (int i = 0; i < 4; i++) {
            loginPage.login(username, wrongPassword);
            String actualErrorMsg = loginPage.getLblLoginErrorMessage().getText();
            String expectedErrorMsg = "Invalid username or password. Please try again.";
            Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Invalid username or password. Please try again. " + (i + 1));
        }
        loginPage.login(username, wrongPassword);
        String actualFinalMsg = loginPage.getLblLoginErrorMessage().getText();
        String expectedFinalMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualFinalMsg, expectedFinalMsg, " After 5 attempts final error message is not displayed as expected.");
    }
}
