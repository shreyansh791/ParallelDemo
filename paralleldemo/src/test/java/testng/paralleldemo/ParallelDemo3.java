package testng.paralleldemo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelDemo3 {
	
@Test
@Parameters({"browser"})
public void chrome(String browser)
{
	System.out.println("Browser Type from testng.xml file is - "+browser);
	WebDriverFactory.getInstance().setCurrentDriver(browser);
WebDriver driver = WebDriverFactory.getInstance().getCurrentDriver();
driver.get("https://www.google.com/");
System.out.println("Title is  - "+  driver.getTitle()); 
driver.quit();

}
}
