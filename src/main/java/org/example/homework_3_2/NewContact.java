package org.example.homework_3_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/*
public class NewContact {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a/span[.='Контрагенты']"))).build().perform();
        driver.findElement(By.xpath("//span[text()='Контактные лица']")).click();

        driver.findElement(By.xpath("//a[.='Создать контактное лицо']")).click();

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Фамилия");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Имя");

//        Select selectOrganized = new Select(driver.findElement(By.name("crm_contact[birthdayRemindBefore]")));
//        selectOrganized.selectByVisibleText("1234");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[3]/div")).click();

        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Должность");
        driver.findElement(By.xpath("//button[contains(.,\"Сохранить и закрыть\")]")).click();

        Thread.sleep(5000);
        driver.quit();


    }


}
*/