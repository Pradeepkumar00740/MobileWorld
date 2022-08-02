package Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {

	@Test(dataProvider="getData")
    public void login(String EmailId, String Password) throws InterruptedException 
    {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\pradeep.k\\eclipse-workspace\\MobileWorld\\Driver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    driver.get("https://mobileworld.azurewebsites.net/");
    Assert.assertEquals(driver.getTitle(), "Mobile");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Assert.assertEquals(driver.getTitle(), "Login");
    Assert.assertEquals("https://mobileworld.azurewebsites.net/sign.html",driver.getCurrentUrl());       
    driver.findElement(By.id("username")).sendKeys(EmailId);
    driver.findElement(By.name("password")).sendKeys(Password);
    driver.findElement(By.xpath("//label[@class='custom-control-label']")).click();
    driver.findElement(By.xpath("//a[text()='Log In']")).click();
    Thread.sleep(2000);
    Assert.assertEquals("https://mobileworld.azurewebsites.net/index.html", driver.getCurrentUrl());
    driver.quit();
    }    

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[5][2];
        data[0][0]="pradeep007@gmail.com ";
        data[0][1]="xxxxx";
        data[1][0]="pradeep123@gmail.com ";
        data[1][1]="yyyyyyyyy";
        data[2][0]="pradeepkumar@gmail.com ";
        data[2][1]="xxxxx";
        data[3][0]="pradeepkumar007@gmail.com ";
        data[3][1]="yyyyyyyy";
        data[4][0]="pradeepkumar123@gmail.com ";
        data[4][1]="edfghj";

        return data;

    }

}
