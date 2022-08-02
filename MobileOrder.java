package Project;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MobileOrder extends Signup{

	 @AfterTest
     public void MobileOrder()
     {
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\pradeep.k\\eclipse-workspace\\MobileWorld\\Driver\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
         driver.get("https://mobileworld.azurewebsites.net/");
         Assert.assertEquals(driver.getTitle(), "Mobile");
         driver.findElement(By.xpath("//a[text()='More Details']")).click();
         Assert.assertEquals("https://mobileworld.azurewebsites.net/mobile.html", driver.getCurrentUrl());
         driver.findElement(By.xpath("(//a[text()='Order'])[2]")).click();
         Assert.assertEquals(driver.getTitle(), "Mobile");
         Set<String> window = driver.getWindowHandles();
         Iterator<String> it = window.iterator();
         String order = it.next();//parent window
         String clickOnOrder = it.next();//child window
         driver.switchTo().window(clickOnOrder);
         driver.findElement(By.id("inputFirstName")).sendKeys(FirstName);
         driver.findElement(By.xpath("(//label[@for='inputLastName'])/following-sibling::input")).sendKeys(LastName);
         driver.findElement(By.id("inputEmail")).sendKeys(EmailId);
         driver.findElement(By.id("inputPassword")).sendKeys(Password);
         driver.findElement(By.id("flexRadioDefault1")).click();
         driver.findElement(By.xpath("//*[@type='number']")).sendKeys(MobileNo);
         driver.findElement(By.id(" address1")).sendKeys("xxxxxx");
         driver.findElement(By.id("address2")).sendKeys("yyyyy");
         driver.findElement(By.xpath("//*[@rel='samsung']")).click();
         WebElement s = driver.findElement(By.cssSelector(".multi_select"));
         Select s1=new Select(s);
         s1.selectByIndex(0);
         driver.findElement(By.xpath("//input[@placeholder='no of mobiles']")).sendKeys("2");
         WebElement no = driver.findElement(By.id("bought"));
         s1.selectByIndex(1);
         driver.findElement(By.id("gridCheck1")).click();
         driver.findElement(By.xpath("(//label[@for='gridCheck1'])[2]")).click();
         driver.findElement(By.xpath("//*[@data-toggle='modal']")).click();
         driver.findElement(By.cssSelector(".modal-body")).getText();
         driver.findElement(By.xpath("//a[text()='Close']")).click();
         System.out.println("Order is Successfully Placed.");
         driver.quit();
     }    

}
