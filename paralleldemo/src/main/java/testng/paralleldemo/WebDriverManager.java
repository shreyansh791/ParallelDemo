package testng.paralleldemo;

import java.io.File;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class WebDriverManager {
	public static LinkedHashMap<Integer, WebDriver> maps = new LinkedHashMap<>();

	public static synchronized WebDriver getCurrentDriver() {
		int id = (int) Thread.currentThread().getId();
		if (!maps.containsKey(id) && maps.get(id)==null) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
					+ "browser_exe" + File.separator + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			maps.put(id, driver);
			return driver;
		} else {
			return maps.get(id);
		}

	}

	@AfterMethod
	public static synchronized void closeBrowser() {
		int id=(int) Thread.currentThread().getId();
		WebDriver driver = maps.get((int) Thread.currentThread().getId());
		if(driver!=null)
		{
			driver.quit();
			driver=null;
			maps.remove(id);
		}
		
	}

}