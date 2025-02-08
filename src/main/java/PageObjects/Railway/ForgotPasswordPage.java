package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends HomePage{
    private final By _txtEmailAddress = By.xpath("//input[@id='email']");
    private final By _btnSendInstruction =By.xpath("//input[@type='submit']");
    private final By _lblForgotWelcomePass = By.xpath("//form//fieldset//legend");

    public WebElement getTxtEmailAddress()
    {
        return Constant.WEBDRIVER.findElement(_txtEmailAddress);
    }
    public WebElement getBtnSendInstruction()
    {
        return Constant.WEBDRIVER.findElement(_btnSendInstruction);
    }
    public WebElement getLblForgotWelcomePass()
    {
        return Constant.WEBDRIVER.findElement(_lblForgotWelcomePass);
    }

    public LoginPage forgotPassword(String email)
    {
        this.getTxtEmailAddress().sendKeys(email);
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", getBtnSendInstruction());
        getBtnSendInstruction().click();
        return new LoginPage();
    }
}
