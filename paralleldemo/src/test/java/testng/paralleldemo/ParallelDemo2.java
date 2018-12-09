package testng.paralleldemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ParallelDemo2 extends WebDriverManager {
	WebDriver driver=null;
@Test
public void test2()
{
	 driver = WebDriverManager.getCurrentDriver();
	driver.get("http://www.google.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("q")).sendKeys("Abhishek jain");
	
}
}
