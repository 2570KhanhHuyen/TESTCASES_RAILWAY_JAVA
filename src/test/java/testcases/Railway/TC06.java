package testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC06 {
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
    public void TC06() {
        System.out.println("TC06 - Additional pages display once user logged in");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.getLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        Assert.assertNotNull(GeneralPage.getTabMyticket());
        Assert.assertNotNull(GeneralPage.getTabChangepassword());
        Assert.assertNotNull(GeneralPage.getTabLogout());

        Assert.assertEquals(loginPage.getMyTicketPage().getTitleManageTicket(), "Manage ticket", "My Ticket User is not directed to My Ticket page.");
        Assert.assertEquals(loginPage.getChangePasswordPage().getTitleChangePassword(), "Change password", "Change Password User is not directed to Change Password page.");
    }
}
