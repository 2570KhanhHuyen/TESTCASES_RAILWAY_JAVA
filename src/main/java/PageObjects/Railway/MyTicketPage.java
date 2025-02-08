package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage{

    private final By _lblTitleManageTicket = By.xpath("//h1[@align='center' and text()='Manage ticket']");

    private String getCancelByTicketID(String ticketID) {
        return "//table[@class='MyTable']//tr[td[input[contains(@onclick,'" + ticketID + "')]]]//input[@value='Cancel']";
    }

    public WebElement geLblTitleManageTicket()
    {
        return Constant.WEBDRIVER.findElement(_lblTitleManageTicket);
    }

    public void cancelTicket(String ticketID) {
        WebElement cancelBtn = Constant.WEBDRIVER.findElement(By.xpath(getCancelByTicketID(ticketID)));
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", cancelBtn);
        cancelBtn.click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public boolean isTicketCancelled(String ticketID) {
        return Constant.WEBDRIVER.findElements(By.xpath(getCancelByTicketID(ticketID))).isEmpty();
    }
}
