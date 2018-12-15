package testng.paralleldemo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	@Parameters({"browser"})
@BeforeMethod
public void setUp(String browser)
{
		System.out.println("Browser Type from testng.xml file is - "+browser);
		WebDriverFactory.getInstance().setCurrentDriver(browser);
		 driver = WebDriverFactory.getInstance().getCurrentDriver();
}
}
