package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "//*[@id=\"menu-appbar\"]/div[3]/ul/li")
    private WebElement logoutBtn;

    /**
     * определение локатора кнопки Orders
     */
    @FindBy(xpath = "//a[contains(text(),'Orders')]")
    private WebElement clickOrder;

    @FindBy(xpath = "//span[contains(text(),'delivered')]")
    private WebElement clickDelivered;

    @FindBy(xpath = "//span[contains(text(),'Jane Doe')]")
    private WebElement selectUser;

    @FindBy(xpath = "//table//tr[1]/td[1]/span/span/input")
    private WebElement selectCheckBox;

    @FindBy(xpath = "//a[contains(text(),'Invoices')]")
    private WebElement clickInvoices;

    @FindBy(xpath = "//a[contains(text(),'Customers')]")
    private WebElement clickCustomers;

    @FindBy(xpath = "//input[@id='date_gte']")
    private WebElement passedSince;

    @FindBy(xpath = "//input[@id='date_lte']")
    private WebElement passedBefore;

    @FindBy(xpath = "//table//tr[1]/td[1]/div/span/*[name()='svg']")
    private WebElement expandRowFromTable;

    @FindBy(xpath = "//table//tr[1]/td[2]/a/div")
    private WebElement firstElement;

    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement address;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='stateAbbr']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement zipcode;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement saveButton;

    private StringBuffer verificationErrors = new StringBuffer();

    public ProfilePage clickMenu() {
        clickOrder.click();
        return this;
    }

    public ProfilePage clickSaveButton() {
        saveButton.click();
        return this;
    }

    public ProfilePage expandRow() {
        expandRowFromTable.click();
        return this;
    }

    public ProfilePage clickFirstItem() {
        firstElement.click();
        return this;
    }

    public ProfilePage clickPassedSince() {
        passedSince.click();
        return this;
    }

    //    ("Ввести значение в поле «passedSince»")
    public ProfilePage setValueInField(String value) {
        passedSince.sendKeys(value);
        return this;
    }

    //    ("Ввести значение в поле «passedSince»")
    public ProfilePage setValueInFieldPassedBefore(String value) {
        passedBefore.sendKeys(value);
        return this;
    }

    public ProfilePage enterCity(String value) {
        city.sendKeys(value);
        return this;
    }

    public ProfilePage clearCity() {
        city.sendKeys(Keys.CONTROL + "a");
        city.sendKeys(Keys.DELETE);
        return this;
    }

    public ProfilePage enterState(String value) {
        state.sendKeys(value);
        return this;
    }

    public ProfilePage clearState() {
        state.sendKeys(Keys.CONTROL + "a");
        state.sendKeys(Keys.DELETE);
        return this;
    }

    public ProfilePage enterAddress(String value) {
        address.sendKeys(value);
        return this;
    }

    public ProfilePage clearAddress() {
        address.sendKeys(Keys.CONTROL + "a");
        address.sendKeys(Keys.DELETE);
        return this;
    }

    public ProfilePage enterZipcode(Integer value) {
        zipcode.sendKeys(value.toString());
        return this;
    }

    public ProfilePage clearZipcode() {
        zipcode.sendKeys(Keys.CONTROL + "a");
        zipcode.sendKeys(Keys.DELETE);
        return this;
    }

    public ProfilePage clickItemDelivered() throws InterruptedException {
        clickDelivered.click();
        Thread.sleep(5000);
        return this;
    }

    public ProfilePage clickItemInvoices() throws InterruptedException {
        clickInvoices.click();
        Thread.sleep(5000);
        return this;
    }

    public ProfilePage clickItemCustomers() throws InterruptedException {
        clickCustomers.click();
        Thread.sleep(5000);
        return this;
    }

    public ProfilePage selectCheckBoxes(List<Integer> checkBoxes) {
        for (Integer checkBox : checkBoxes) {
            driver.findElement(By.xpath(String.format("//table//tr[%d]/td[1]/span/span/input", checkBox))).click();
        }
        return this;
    }

    public ProfilePage checkLabel(int quantity) {
        assertTrue(driver.findElement(By.xpath(String.format("//h6[text()='%d items selected']", quantity)))
                .getText().contains(String.format("%d items selected", quantity)));
        return this;
    }

    public ProfilePage isTextPresented(String text) {
        assertTrue(driver.findElement(By.xpath(String.format("//h6[text()='%s']", text)))
                .getText().contains(String.format("%s", text)));
        return this;
    }

    public ProfilePage userLogout() {
        selectUser.click();
        logoutBtn.click();
        return this;
    }
}

