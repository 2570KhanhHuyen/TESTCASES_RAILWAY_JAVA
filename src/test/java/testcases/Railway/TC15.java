package testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TimeTablePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC15 {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition: Setting up the WebDriver");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition: Quitting the WebDriver");
        if (Constant.WEBDRIVER != null) {
            Constant.WEBDRIVER.quit();
        }
    }

    @Test
    public void TC15() {
        System.out.println("TC15 - User can open Book ticket page by clicking on Book ticket link in Train timetable page");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.getLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        TimeTablePage timeTablePage = homePage.getTimeTablePage();
        String depart="Sài Gòn";
        String arrive="Huế";
        timeTablePage.clickBookTicketLink(depart, arrive);

        BookTicketPage bookTicketPage = new BookTicketPage();
        String departFrom = bookTicketPage.getDepartFromSelected();
        String arriveAt = bookTicketPage.getArriveAtSelected();
        Assert.assertEquals(departFrom, depart, "Depart from value is incorrect!");
        Assert.assertEquals(arriveAt, arrive, "Arrive at value is incorrect!");
    }
}
