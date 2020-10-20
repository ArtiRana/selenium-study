package com.qa.seleniumstudy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class webElementPractice {
    private final String baseUrl = "https://www.qaguru.ca/webelementapp.php";
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void selectGender(){
        WebElement radMale = driver.findElement(By.xpath("//*[@id=\"home-5\"]/form[2]/input[1]"));
        Assert.assertTrue(radMale.isSelected(),"Male radio button is not selected by default");

        driver.findElement(By.xpath("//*[@id=\"home-5\"]/form[2]/input[2]"))
                .click();
    }

    @Test
    public void SetTextBox()
    {
        WebElement webElement= driver.findElement(By.name("firstname"));
        webElement.clear();
        webElement.sendKeys("john");

    }

    @Test
    public void ListBox()
    {
        WebElement webElement=driver.findElement(By.name("cars"));
        Select select=new Select(webElement);
        select.selectByVisibleText("Audi");
        List<WebElement> webElements= select.getOptions();
        for(WebElement we: webElements)
            System.out.println(we.getText());

    }

    @Test
    public void checkBox()
    {
        driver.findElement(By.name("vehicle1")).click();
    }


}
