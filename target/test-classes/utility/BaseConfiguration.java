package utility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseConfiguration extends Driver{

	//private static final String baseURL = "https://www.amazon.in";
	//private static final String baseURL = "http://newtours.demoaut.com/";
	private static final String baseURL = "http://automationpractice.com/index.php";
	
	public static String getBaseURL() {
		return baseURL;
	}

	@BeforeClass
	public void openApplicationUnderTest() {
		System.out.println("BeforeClass annotation");
		Driver.getDriver().get(getBaseURL());
		Driver.getDriver().manage().window().maximize();
	}

	public void waitforPresent(String element) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorUtil.getBy(element)));
		} catch (Exception e) {
			if (!LocatorUtil.secondPart.equals(null)) {
				System.setProperty("secondLocator", LocatorUtil.secondPart);
				wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorUtil.getBy("secondLocator")));
			}
		}
	}

	public WebElement findElement(String locator) {
		try {
			return Driver.getDriver().findElement(LocatorUtil.getBy(locator));
		} catch (Exception e) {
			if (!LocatorUtil.secondPart.equals(null)) {
				System.setProperty("secondLocator", LocatorUtil.secondPart);
				return Driver.getDriver().findElement(LocatorUtil.getBy("secondLocator"));
			}
		}
		return null;
	}

	public List<WebElement> findElements(String locator) {
		return Driver.getDriver().findElements(LocatorUtil.getBy(locator));
	}

	public void clickOnElement(String locator) {
		findElement(locator).click();
	}

	public void sendValue(String locator, String value) {
		findElement(locator).sendKeys(value);
	}
	
	public boolean verifytext(String locator, String value) {
		if (findElement(locator).getText().equals(value)) {
			System.out.println(findElement(locator).getText()+ " label is ***********");
			return true;
		}
		return false;
	}

	@BeforeTest
	public void readConfig(ITestContext context) {
		System.out.println("beforetest annotation");
		PropertyFileReader.fileReader();
		//System.out.println(context.getCurrentXmlTest().getAllParameters() + "aaaaaaaa");
	}

}
