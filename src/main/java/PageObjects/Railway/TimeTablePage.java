package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage{
    private String getBookTicketLink(String depart, String arrive) {
        return "//table[@class='MyTable WideTable']//tr[td[contains(text(),'"+ depart +"')] and td[contains(text(),'"+ arrive +"')]]//following-sibling::td//a[contains(text(),'book ticket')]";
    }

    public void clickBookTicketLink(String depart, String arrive) {
        WebElement bookTicketLink = Constant.WEBDRIVER.findElement(By.xpath(getBookTicketLink(depart, arrive)));
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", bookTicketLink);
        bookTicketLink.click();
    }
}
