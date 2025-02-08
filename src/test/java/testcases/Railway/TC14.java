package testcases.Railway;

import Common.Common.mkyong.time.CurrentDate;
import Common.Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class TC14 {

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
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");

        String expectedBookTicketSuccessMessage = "Ticket booked successfully!";

        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.getLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        BookTicketPage bookTicketPage = homePage.getBookTicketPage();
        String departDate = CurrentDate.getFormattedDate();
        String departFrom = bookTicketPage.getDefaultDepartFrom();
        String arriveAt = bookTicketPage.getDefaultArriveAt();
        String seatType = bookTicketPage.getDefaultSeatType();
        int ticketAmount = bookTicketPage.getDefaultTicketAmount();

        String ticketID = bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);

        String bookTicketSuccessMessage = bookTicketPage.getLblBookingMsg().getText();
        Assert.assertEquals(bookTicketSuccessMessage, expectedBookTicketSuccessMessage);

        Assert.assertTrue(bookTicketPage.isBookedTicketInfoCorrect(departDate, departFrom, arriveAt, seatType, ticketAmount));
    }
}

