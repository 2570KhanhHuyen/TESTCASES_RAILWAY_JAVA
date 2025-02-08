package testcases.Railway;

import Common.Common.mkyong.time.CurrentDate;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC16 {
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
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.getLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        BookTicketPage bookTicketPage = homePage.getBookTicketPage();

        String depart="Nha Trang";
        String arrive="Đà Nẵng";
        String seat="Hard seat";
        int ticket=1;

        String departDate = CurrentDate.getFormattedDate();
        String departFrom =depart;
        String arriveAt = arrive;
        String seatType = seat;
        int ticketAmount=ticket;
        String ticketID = bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);
        System.out.println("Ticket ID: " + ticketID);

        MyTicketPage myTicketPage = homePage.getMyTicketPage();
        myTicketPage.cancelTicket(ticketID);

        boolean isCancelled = myTicketPage.isTicketCancelled(ticketID);
        Assert.assertTrue(isCancelled, "Ticket was not canceled successfully.");
    }
}
