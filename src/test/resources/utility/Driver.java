package utility;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Driver {

	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			createNewDriverInstance();
		}
		return driver;
	}

	public static void createNewDriverInstance() {
		String browser = new PropertyReader().readProperty("browser");

		if (browser.equals("firefox")) {

			File path = new File("");
			String fileLocation = path.getAbsolutePath() + "/src/test/resource/drivers/" + "geckodriver.exe";
			System.out.println("Location :  " + fileLocation);
			System.setProperty("webdriver.gecko.driver", fileLocation);
			System.out.println("Firefox is about to launch");
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("chrome")) {

			// Here I am setting up the path for my chromedriver

			File path = new File("");
			String fileLocation = path.getAbsolutePath() + "/src/test/resources/drivers/" + "chromedriver.exe";
			System.out.println("Location :  " + fileLocation);
			System.setProperty("webdriver.chrome.driver", fileLocation);
			System.out.println("Chrome is about to launch");
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("ie")) {

			// Here I am setting up the path for my IEDriver

			System.setProperty("webdriver.ie.driver", "D:/Framework/Desktop/Watchable/resources/IEDriverServer.exe");
			System.out.println("Internet Explorer is about to launch");
			driver = new InternetExplorerDriver();

		}

	}

	
	  public void destroyDriver() { 
		  driver.quit(); 
	  driver = null; 
	  }
	@AfterClass
	public void closeDriver() {
		if (driver != null) {
			System.out.println("afterClass executed");
			System.out.println("Closing the browser");
			driver.close();
		}
	}

}
