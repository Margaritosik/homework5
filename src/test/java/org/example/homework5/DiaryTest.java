package org.example.homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.util.Date;

public class DiaryTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        login(driver);


    }

    @Test
    public void createBlogPost() throws InterruptedException {

        Date date = new Date();
        String textBody = new Timestamp(date.getTime()).toString();
        String textHeader = new Timestamp(date.getTime()).toString() + "1";

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='writeThisDiary']/a")));
        driver.findElement(By.xpath("//li[@id='writeThisDiary']/a")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='new_post_title']")));

        driver.findElement(By.name("BlogsPosts[title]")).sendKeys(textHeader);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'message_ifr')]")));
        driver.findElement(By.xpath("//body")).sendKeys(textBody);
        driver.switchTo().defaultContent();

        driver.findElement(By.name("rewrite")).click();

        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"post-inner\"]")).getText(), textBody);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void login(WebDriver driver) throws InterruptedException {
        driver.get("https://diary.ru");
        Cookie cookie = new Cookie("_identity_", "81ac8213fe63de596053e6c690680eaf6e054bdfaee98119547a0ccd63a99ca0a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3558804%2C%22JN8D4ddEFe-k4utTFKx5EqOxbqeQKyaa%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.get("https://diary.ru");
    }

    static void oldLogin(WebDriver driver) throws InterruptedException {
        driver.get("https://diary.ru/user/login");
        WebElement element = driver.findElement(By.id("loginform-username"));
        element.sendKeys("Margaritosik");
        driver.findElement(By.id("loginform-password")).sendKeys("1227Depr");
        driver.findElement(By.id("login_btn")).click();
    }

}
