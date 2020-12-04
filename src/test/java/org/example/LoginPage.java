package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора поля ввода логина
     */
//    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    @FindBy(xpath = "//input[contains(@name,'username')]")
        private WebElement loginField;
    /**
     * определение локатора кнопки входа в аккаунт
     */
//    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    @FindBy(xpath = "//*[contains(text(), 'Sign in')]/..")
    private WebElement loginBtn;
    /**
     * определение локатора поля ввода пароля
     */
//    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    @FindBy(xpath = "//input[contains(@name,'password')]")
    private WebElement passwdField;
    /**
     * метод для ввода логина
     */
    public LoginPage inputLogin(String login) {
        loginField.click();
        loginField.sendKeys(login);
        return this;
    }
    /**
     * метод для ввода пароля
     */
    public LoginPage inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
        return this;}
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }
}
