package testng.paralleldemo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelDemo4 {
	@Test
	@Parameters({"browser"})
	public void firefox(String browser)
	{
		System.out.println("Browser Type from testng.xml file is - "+browser);
		WebDriverFactory.getInstance().setCurrentDriver(browser);
	WebDriver driver = WebDriverFactory.getInstance().getCurrentDriver();
	driver.get("https://www.facebook.com/");
	System.out.println("Title is  - "+  driver.getTitle()); 
driver.quit();
	}
}
