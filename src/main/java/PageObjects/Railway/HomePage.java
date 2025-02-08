package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[contains(@href, 'ManageTicket')]");
    private final By tabChangePassword = By.xpath("//a[@href='/ChangePassword.cshtml']");
    private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//a[@href='/Login']");
    public HomePage open()
    {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
