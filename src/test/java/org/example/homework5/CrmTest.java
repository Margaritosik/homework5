package org.example.homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;
import java.util.concurrent.TimeUnit;

public class CrmTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        login(driver);
    }

    @Test
    public void createContact() throws InterruptedException {

        actions.moveToElement(driver.findElement(By.xpath("//a/span[.='Контрагенты']"))).build().perform();

        driver.findElement(By.xpath("//span[text()='Контактные лица']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[.='Создать контактное лицо']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_contact[lastName]")));
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Фамилия");

        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Имя");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[3]/div")));
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[3]/div")).click();

        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Должность");
        driver.findElement(By.xpath("//button[contains(.,\"Сохранить и закрыть\")]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"message\"]")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class=\"message\"]")).isDisplayed());

    }

    @Test
    public void createProject() throws InterruptedException {

        actions.moveToElement(driver.findElement(By.xpath("//a/span[.='Проекты']"))).build().perform();
        driver.findElement(By.xpath("//span[text()='Все проекты']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать проект']")));
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("Наименоваd2222ddние1");

        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[3]/div")));
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[3]/div")).click();

        Select selectBusiness = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusiness.selectByVisibleText("Research & Development");

        Select selectCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectCurator.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select selectPM = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectPM.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select selectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectManager.selectByVisibleText("Applanatest Applanatest Applanatest");

        Thread.sleep(1000); // Без этого не работает, пробовала через webDriverWait.

        driver.findElement(By.xpath("//div[contains(@id,\"s2id_crm_project_contactMain-uid\")]/a")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")));
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")).click();

        driver.findElement(By.xpath("//button[contains(.,\"Сохранить и закрыть\")]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"message\"]")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class=\"message\"]")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void login(WebDriver driver) {
        driver.get("https://crm.geekbrains.space/user/login"); // ??
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
