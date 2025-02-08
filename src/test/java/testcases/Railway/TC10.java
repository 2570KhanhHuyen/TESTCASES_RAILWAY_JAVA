package testcases.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;

public class TC10 {
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
    public void TC10() {
        System.out.println("TC10 - User can't create account with Confirm password is not the same with Password");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage= homePage.getRegisterPage();
        String actualErrorMsg = registerPage.register(Constant.EMAIL, Constant.PASS, "123123124", Constant.PID).getErrorMsg();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
}
