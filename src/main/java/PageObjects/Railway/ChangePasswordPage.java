package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {
    private final By _txtCurrentPass = By.xpath("//input[@id='currentPassword']");
    private final By _txtNewPass = By.xpath("//input[@id='newPassword']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By _lblTitleChangePassword = By.xpath("//h1[@align='center' and text()='Change password']");
    private final By _lblChangePassWelMsg = By.xpath("//p [@class='message success']");

    public WebElement getTxtCurrentPass() {
        return Constant.WEBDRIVER.findElement(_txtCurrentPass);
    }

    public WebElement getTxtNewPass() {
        return Constant.WEBDRIVER.findElement(_txtNewPass);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }

    public WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(_btnChangePassword);
    }
    public WebElement geLblTitleChangePassword()
    {
        return Constant.WEBDRIVER.findElement(_lblTitleChangePassword);
    }
    public WebElement geLblChangePassWelMsg()
    {
        return Constant.WEBDRIVER.findElement(_lblChangePassWelMsg);
    }
    public HomePage changePassword(String currentPass, String newPass, String confirmPass) {
        this.getTxtCurrentPass().sendKeys(currentPass);
        this.getTxtNewPass().sendKeys(newPass);
        this.getTxtConfirmPassword().sendKeys(confirmPass);
        this.getBtnChangePassword().click();
        return new HomePage();
    }
}
