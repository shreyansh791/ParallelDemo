package testng.paralleldemo;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	private static WebDriverFactory instance;
	private WebDriverFactory()
	{
		
	}
	public static WebDriverFactory getInstance()
	{
		if(instance==null)
			instance=new WebDriverFactory();
		else
			return instance;
		return instance;
	}
	public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();

	public void setCurrentDriver(String browserType) {

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
					+ "browser_exe" + File.separator + "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			webdriver.set(driver);
		} else if (browserType.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator
					+ "browser_exe" + File.separator + "geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			webdriver.set(driver);
		}
		else
		{
			System.out.println("wrong browser passed...");
		}

	}
	public WebDriver getCurrentDriver()
	{
		return webdriver.get();
	}
}
