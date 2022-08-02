package Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class Signup {

	 String EmailId="pradeepkumar007@gmail.com";
     String Password="pradi123";
     String FirstName = "Pradeep";
     String LastName ="kumar";
     String MobileNo="9876543210";
     String DOB="19/01/1997";
     String ShortBio = "Hi";
     String Expected="Hai,Pradeep! Go To SingIn";
    static
    {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\pradeep.k\\eclipse-workspace\\MobileWorld\\Driver\\chromedriver.exe");
    }
    @BeforeTest
public void SignUp() throws InterruptedException
{

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    driver.get("https://mobileworld.azurewebsites.net/");
    Assert.assertEquals(driver.getTitle(), "Mobile");  
    driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
    Assert.assertEquals(driver.getTitle(), "Login");
    Assert.assertEquals("https://mobileworld.azurewebsites.net/sign.html",driver.getCurrentUrl());
    driver.findElement(By.xpath("//*[text()='Sign up']")).click();
    Assert.assertEquals(driver.getTitle(), "Register");
    driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(FirstName );
    driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(LastName);
    driver.findElement(By.xpath("//*[@placeholder='Enter Email']")).sendKeys(EmailId);
    driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(Password);
    driver.findElement(By.xpath("//*[@type='date']")).sendKeys(DOB);
    driver.findElement(By.name("gender")).click();
    driver.findElement(By.xpath("//*[@type='number']")).sendKeys(MobileNo);
    driver.findElement(By.xpath("//*[@placeholder='Short Bio']")).sendKeys(ShortBio);
    driver.findElement(By.xpath("//button[text()='Register']")).click();
    Thread.sleep(2000);
    driver.switchTo().alert().getText();
    Assert.assertEquals(driver.switchTo().alert().getText(), Expected);
    driver.switchTo().alert().accept();
    driver.quit();
}
}
