package PageObjects.Railway;

import Common.Common.mkyong.time.CurrentDate;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private final By _ddlDepartDate = By.xpath("//select[@name='Date']");
    private final By _ddlDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By _ddlArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By _ddlSeatType = By.xpath("//select[@name='SeatType']");
    private final By _ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By _btnBookTicket = By.xpath("//input[@type='submit' and @value='Book ticket'] ");
    private final By _lblBookingMsg = By.xpath("//h1[@align='center' and text()='Ticket booked successfully!']");

    private final By _cclDepartDate = By.xpath("//table[@class='MyTable WideTable']//td[count(//table[@class='MyTable WideTable']//th[text()='Book Date']/preceding-sibling::th)]");
    private final By _cclDepartFrom = By.xpath("//table[@class='MyTable WideTable']//td[count(//table[@class='MyTable WideTable']//th[text()='Arrive Station']/preceding-sibling::th)]");
    private final By _cclArriveAt = By.xpath("//table[@class='MyTable WideTable']//td[count(//table[@class='MyTable WideTable']//th[text()='Seat Type']/preceding-sibling::th)]");
    private final By _cclSeatType = By.xpath("//table[@class='MyTable WideTable']//td[count(//table[@class='MyTable WideTable']//th[text()='Depart Date']/preceding-sibling::th)]");
    private final By _cclTicketAmount = By.xpath("//table[@class='MyTable WideTable']//td[count(//table[@class='MyTable WideTable']//th[text()='Total Price']/preceding-sibling::th)]");


    private String defaultDepartFrom = "Sài Gòn";
    private String defaultArriveAt = "Nha Trang";
    private String defaultSeatType = "Soft bed with air conditioner";
    private int defaultTicketAmount = 1;

    public String getDefaultDepartFrom() {
        return defaultDepartFrom;
    }

    public void setDefaultDepartFrom(String defaultDepartFrom) {
        this.defaultDepartFrom = defaultDepartFrom;
    }

    public String getDefaultArriveAt() {
        return defaultArriveAt;
    }

    public void setDefaultArriveAt(String defaultArriveAt) {
        this.defaultArriveAt = defaultArriveAt;
    }

    public String getDefaultSeatType() {
        return defaultSeatType;
    }

    public void setDefaultSeatType(String defaultSeatType) {
        this.defaultSeatType = defaultSeatType;
    }

    public int getDefaultTicketAmount() {
        return defaultTicketAmount;
    }

    public void setDefaultTicketAmount(int defaultTicketAmount) {
        this.defaultTicketAmount = defaultTicketAmount;
    }

    public WebElement getDdlDepartDate() {
        return Constant.WEBDRIVER.findElement(_ddlDepartDate);
    }

    public WebElement getDdlDepartFrom() {
        return Constant.WEBDRIVER.findElement(_ddlDepartFrom);
    }

    public WebElement getDdlArriveAt() {
        return Constant.WEBDRIVER.findElement(_ddlArriveAt);
    }

    public WebElement getDdlSeatType() {
        return Constant.WEBDRIVER.findElement(_ddlSeatType);
    }

    public WebElement getDdlTicketAmount() {
        return Constant.WEBDRIVER.findElement(_ddlTicketAmount);
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(_btnBookTicket);
    }

    public WebElement getLblBookingMsg() {
        return Constant.WEBDRIVER.findElement(_lblBookingMsg);
    }

    public WebElement getCclDepartDate() {
        return Constant.WEBDRIVER.findElement(_cclDepartDate);
    }

    public WebElement getCclDepartFrom() {
        return Constant.WEBDRIVER.findElement(_cclDepartFrom);
    }

    public WebElement getCclArriveAt() {
        return Constant.WEBDRIVER.findElement(_cclArriveAt);
    }

    public WebElement getCclSeatType() {
        return Constant.WEBDRIVER.findElement(_cclSeatType);
    }

    public WebElement getCclTicketAmount() {
        return Constant.WEBDRIVER.findElement(_cclTicketAmount);
    }

    public String bookTicket() {
        return bookTicket(CurrentDate.getFormattedDate(), defaultDepartFrom, defaultArriveAt, defaultSeatType, defaultTicketAmount);
    }
    public String getDepartFromSelected() {
        WebElement departFromElement = Constant.WEBDRIVER.findElement(_ddlDepartFrom);
        Select select = new Select(departFromElement);
        return select.getFirstSelectedOption().getText();
    }

    public String getArriveAtSelected() {
        WebElement arriveAtElement = Constant.WEBDRIVER.findElement(_ddlArriveAt);
        Select select = new Select(arriveAtElement);
        return select.getFirstSelectedOption().getText();
    }

    public String bookTicket(String departDate, String departFrom, String arriveAt, String seatType, int ticketAmount) {
        String formattedDate = CurrentDate.getFormattedDate();
        Select departDateSelect = new Select(this.getDdlDepartDate());
        departDateSelect.selectByVisibleText(departDate);
        Select departFromSelect = new Select(this.getDdlDepartFrom());
        departFromSelect.selectByVisibleText(departFrom);
        Select arriveAtSelect = new Select(this.getDdlArriveAt());
        arriveAtSelect.selectByVisibleText(arriveAt);
        Select seatSelect = new Select(this.getDdlSeatType());
        seatSelect.selectByVisibleText(seatType);
        Select ticketAmountSelect = new Select(this.getDdlTicketAmount());
        ticketAmountSelect.selectByVisibleText(String.valueOf(ticketAmount));
        this.getBtnBookTicket().click();

        String successUrl = Constant.WEBDRIVER.getCurrentUrl();
        return successUrl.split("id=")[1];
    }

    public boolean isBookedTicketInfoCorrect
    (String expectedDepartDate, String expectedDepartFrom,
                                             String expectedArriveAt, String expectedSeatType,
                                             int expectedTicketAmount) {

        String actualDepartDate = Constant.WEBDRIVER.findElement(_cclDepartDate).getText();
        String actualDepartFrom = Constant.WEBDRIVER.findElement(_cclDepartFrom).getText();
        String actualArriveAt = Constant.WEBDRIVER.findElement(_cclArriveAt).getText();
        String actualSeatType = Constant.WEBDRIVER.findElement(_cclSeatType).getText();
        String actualTicketAmount = Constant.WEBDRIVER.findElement(_cclTicketAmount).getText();

        return actualDepartDate.equals(expectedDepartDate) &&
                actualDepartFrom.equals(expectedDepartFrom) &&
                actualArriveAt.equals(expectedArriveAt) &&
                actualSeatType.equals(expectedSeatType) &&
                actualTicketAmount.equals(String.valueOf(expectedTicketAmount));
    }
}

