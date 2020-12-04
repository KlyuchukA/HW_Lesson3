package org.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() throws InterruptedException {
        //значение login/password берутся из файла настроек по аналогии с chromedriver
//и loginpage //вводим логин
        List<Integer> checkBoxesIndex = new ArrayList<Integer>();
        checkBoxesIndex.add(1);
        checkBoxesIndex.add(2);
        checkBoxesIndex.add(3);

        new LoginPage(driver)
                .inputLogin(ConfProperties.getProperty("login"))
                .inputPasswd(ConfProperties.getProperty("password"))
                .clickLoginBtn();

        new ProfilePage(driver)
                .clickMenu()
                .clickItemDelivered()
                .selectCheckBoxes(checkBoxesIndex)
                .checkLabel(checkBoxesIndex.size())

                .clickItemInvoices()
                .setValueInField("19.10.2020")
                .setValueInFieldPassedBefore("29.10.2020")
                .expandRow()
                .isTextPresented("Posters Galore")

                .clickMenu()
                .clickItemCustomers()
                .clickFirstItem()
                .clearAddress()
                .enterAddress("600 E. 32nd Avenue Anchorage")
                .clearCity()
                .clearState()
                .clearZipcode()
                .enterAddress("600 E. 32nd Avenue Anchorage")
                .enterCity("Anchorage")
                .enterState("Alaska")
                .enterZipcode(99503)
                .clickSaveButton()
                .clickMenu()
                .userLogout();
    }

    @AfterClass
    public static void tearDown() {
        profilePage.clickMenu();
        profilePage.userLogout();
        driver.quit();
    }
}