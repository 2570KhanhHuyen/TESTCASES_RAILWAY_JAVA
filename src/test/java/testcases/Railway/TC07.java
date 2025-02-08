package testcases.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;

public class TC07 {
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
    public void TC07(){
        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage= homePage.getRegisterPage();
        String actualMsg = registerPage.register(Constant.EMAIL, Constant.PASS, Constant.CONFIRMPASS, Constant.PID).getRegisterWelMsg();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg,expectedMsg, "Welcome message is not displayed as expected");
    }
}
