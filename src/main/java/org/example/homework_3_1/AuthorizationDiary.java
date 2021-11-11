package org.example.homework_3_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class AuthorizationDiary {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://diary.ru/user/login");
        login(driver);

        Thread.sleep(5000);
        driver.quit();


    }

    static void login(WebDriver driver) throws InterruptedException {
        WebElement element = driver.findElement(By.id("loginform-username"));
        element.sendKeys("Margaritosik");
        driver.findElement(By.id("loginform-password")).sendKeys("1227Depr");
        Thread.sleep(5000);
        //driver.findElement(By.id("recaptcha-anchor")).click();
        driver.findElement(By.id("login_btn")).click();
    }

}
