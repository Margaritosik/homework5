package org.example.homework_3_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class NewProject {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a/span[.='Проекты']"))).build().perform();
        driver.findElement(By.xpath("//span[text()='Все проекты']")).click();

        driver.findElement(By.xpath("//a[.='Создать проект']")).click();

        driver.findElement(By.name("crm_project[name]")).sendKeys("Наименование1");

        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[3]/div")).click();

        Select selectBusiness = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusiness.selectByVisibleText("Research & Development");

        Select selectCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectCurator.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select selectPM = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectPM.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select selectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectManager.selectByVisibleText("Applanatest Applanatest Applanatest");

        driver.findElement(By.xpath("//div[contains(@id,\"s2id_crm_project_contactMain-uid\")]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")).click();

        driver.findElement(By.xpath("//button[contains(.,\"Сохранить и закрыть\")]")).click();

        Thread.sleep(5000);
        driver.quit();

    }


    static void login(WebDriver driver) {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
