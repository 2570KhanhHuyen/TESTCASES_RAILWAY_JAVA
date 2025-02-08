package PageObjects.Railway;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{

    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin =By.xpath("//input[@value='login']");
    private final By _lblLoginErrorMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By _lblTitleLoginPage = By.xpath("//h1[@align='center' and text()='Login page']");
    private final By _linkForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");

    public WebElement getTxtUsername()
    {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }
    public WebElement getTxtPassword()
    {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getBtnLogin()
    {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }
    public WebElement getLblLoginErrorMessage()
    {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMessage);
    }
    public WebElement geLblTitleLoginPage()
    {
        return Constant.WEBDRIVER.findElement(_lblTitleLoginPage);
    }
    public WebElement getLinkForgotPassword()
    {
        return Constant.WEBDRIVER.findElement(_linkForgotPassword);
    }

    public HomePage login(String username, String password)
    {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        return new HomePage();
    }
    public ForgotPasswordPage getForgotPassword() {
        this.getLinkForgotPassword().click();
        return new ForgotPasswordPage();
    }
}
