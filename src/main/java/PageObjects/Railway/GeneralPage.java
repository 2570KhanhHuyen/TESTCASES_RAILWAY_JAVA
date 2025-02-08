package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GeneralPage {

    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private static final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private static final By tabTimetable = By.xpath("//div[@id='menu']//a[contains(@href, 'Time')]");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblErrorMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By tabBookticket = By.xpath("//div[@id='menu']//a[contains(@href, 'BookTicket')]");
    private static final By tabMyticket = By.xpath("//div[@id='menu']//a[contains(@href, 'ManageTicket')]");
    private static final By tabChangepassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By lblErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblErrorPassword = By.xpath("//label[@for='password' and contains(@class, 'validation-error')]");
    private final By lblErrorPid = By.xpath("//label[@for='pid' and contains(@class, 'validation-error')]");
    private final By lblForgotWelcomePass = By.xpath("//form//fieldset//legend");
    private final By lblBookingMsg = By.xpath("//div[@class='error-message']");
    private final By lblTitleLoginPage = By.xpath("//h1[@align='center' and text()='Login page']");
    private final By _lblTitleManageTicket = By.xpath("//h1[@align='center' and text()='Manage ticket']");
    private final By _lblTitleChangePassword = By.xpath("//h1[@align='center' and text()='Change password']");
    private final By _lblRegisterWelMsg = By.xpath("//div[@id='content']/p[text()='Registration Confirmed! You can now log in to the site.']");
    private final By _lblChangePassWelMsg = By.xpath("//p [@class='message success']");


    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    public static WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    public static WebElement getTabTimetable() {
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    protected WebElement getTabBookticket() {
        return Constant.WEBDRIVER.findElement(tabBookticket );
    }

    public static WebElement getTabMyticket() {
        return Constant.WEBDRIVER.findElement(tabMyticket);
    }

    public static WebElement getTabChangepassword() {
        return Constant.WEBDRIVER.findElement(tabChangepassword);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getLblErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblErrorMessage);
    }
    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }
    protected WebElement getLblErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorMsg);
    }
    protected WebElement getLblErrorPassword() {
        return Constant.WEBDRIVER.findElement(lblErrorPassword);
    }
    protected WebElement getLblErrorPid() {
        return Constant.WEBDRIVER.findElement(lblErrorPid);
    }
    protected WebElement getLblForgotWelcomePass() {
        return Constant.WEBDRIVER.findElement(lblForgotWelcomePass);
    }
    protected WebElement getLblBookingMsg() {
        return Constant.WEBDRIVER.findElement(lblBookingMsg);
    }
    protected WebElement getLblTitleLoginPage() {
        return Constant.WEBDRIVER.findElement(lblTitleLoginPage);
    }
    protected WebElement getLblTitleManageTicket() {
        return Constant.WEBDRIVER.findElement(_lblTitleManageTicket);
    }
    protected WebElement getLblTitleChangePassword() {
        return Constant.WEBDRIVER.findElement(_lblTitleChangePassword);
    }
    protected WebElement getLblRegisterWelMsg() {
        return Constant.WEBDRIVER.findElement(_lblRegisterWelMsg);
    }
    protected WebElement getLblChangePassWelMsg() {
        return Constant.WEBDRIVER.findElement(_lblChangePassWelMsg);
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }
    public String getErrorMessage() {
        return this.getLblErrorMessage().getText();
    }
    public LoginPage getLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }
    public TimeTablePage getTimeTablePage() {
        this.getTabTimetable().click();
        return new TimeTablePage();
    }
    public BookTicketPage getBookTicketPage() {
        this.getTabBookticket().click();
        return new BookTicketPage();
    }
    public MyTicketPage getMyTicketPage() {
        this.getTabMyticket().click();
        return new MyTicketPage();
    }
    public ChangePasswordPage getChangePasswordPage () {
        this.getTabChangepassword().click();
        return new ChangePasswordPage();
    }
    public RegisterPage getRegisterPage () {
        this.getTabRegister().click();
        return new RegisterPage();
    }
    public String getErrorMsg() {
        return this.getLblErrorMsg().getText();
    }
    public String getErrorPassword() {
        return this.getLblErrorPassword().getText();
    }
    public String getErrorPid() {
        return this.getLblErrorPid().getText();
    }
    public String getForgotWelcomePass() {
        return this.getLblForgotWelcomePass().getText();
    }
    public String getBookingMsg(){
        return this.getLblBookingMsg().getText();
    }
    public String getTitleLoginPage(){
        return this.getLblTitleLoginPage().getText();
    }
    public String getTitleManageTicket(){
        return this.getLblTitleManageTicket().getText();
    }
    public String getTitleChangePassword(){
        return this.getLblTitleChangePassword().getText();
    }
    public String getRegisterWelMsg(){
        return this.getLblRegisterWelMsg().getText();
    }
    public String getChangePassWelMsg(){
        return this.getLblChangePassWelMsg().getText();
    }
}

