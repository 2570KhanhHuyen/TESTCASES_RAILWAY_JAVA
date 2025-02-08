package testcases.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class TC09  {
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
    public void TC09() {
        System.out.println("TC09 - User can change password");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage= homePage.getRegisterPage();
        registerPage.register(Constant.EMAIL, Constant.PASS, Constant.CONFIRMPASS, Constant.PID);
        LoginPage loginPage = homePage.getLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASS);
        ChangePasswordPage changePasswordPage = homePage.getChangePasswordPage();
        String newPassword = "123456789";
        String actualMsg =changePasswordPage.changePassword(Constant.PASS, newPassword, newPassword).getChangePassWelMsg();
        String expectedMsg = "Your password has been updated!";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
