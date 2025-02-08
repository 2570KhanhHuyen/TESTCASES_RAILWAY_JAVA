package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{

    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _txtPass = By.xpath("//input[@id='password']");
    private final By _txtConfirmPass = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPID = By.xpath("//input[@id='pid']");
    private final By _btnRegister =By.xpath("//input[@value='Register']");
    private final By _lblErrorMsg = By.xpath("//p[@class='message error']");
    private final By _lblErrorPassword = By.xpath("//label[@for='password' and contains(@class, 'validation-error')]");
    private final By _lblErrorPid = By.xpath("//label[@for='pid' and contains(@class, 'validation-error')]");
    private final By _lblRegisterWelMsg = By.xpath("//div[@id='content']/p[text()='Registration Confirmed! You can now log in to the site.']");

    public WebElement getTxtUsername()
    {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword()
    {
        return Constant.WEBDRIVER.findElement(_txtPass);
    }
    public WebElement getTxtConfirmPass()
    {
        return Constant.WEBDRIVER.findElement(_txtConfirmPass);
    }
    public WebElement getTxtPid()
    {
        return Constant.WEBDRIVER.findElement(_txtPID);
    }
    public WebElement getBtnRegister()
    {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    public WebElement getLblErrorPassword()
    {
        return Constant.WEBDRIVER.findElement(_lblErrorPassword);
    }
    public WebElement getLblErrorPid()
    {
        return Constant.WEBDRIVER.findElement(_lblErrorPid);
    }
    public WebElement getLblRegisterWelMsg()
    {
        return Constant.WEBDRIVER.findElement(_lblRegisterWelMsg);
    }

    public RegisterPage register(String email, String pass, String confirmPass, String pid)
    {
        this.getTxtUsername().sendKeys(email);
        this.getTxtPassword().sendKeys(pass);
        this.getTxtConfirmPass().sendKeys(confirmPass);
        this.getTxtPid().sendKeys(pid);
        this.getBtnRegister().click();
        return new RegisterPage();
    }
}
